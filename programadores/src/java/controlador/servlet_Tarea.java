/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.Programador;
import modelo.Proyecto;
import modelo.Tarea;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author FRAGATA
 */
public class servlet_Tarea extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        
         String action=request.getParameter("action");
         
         if(action.equals("consultarPP")){
             
                        SessionFactory sf=HibernateUtil.getSessionFactory();
                        Session sesion=sf.openSession();
                        sesion.beginTransaction();
                      
                        try{ 
                            Query consulta1=sesion.createQuery("FROM Programador");
                            List <Programador> programadores=consulta1.list();
                            
                            Query consulta2=sesion.createQuery("FROM Proyecto");
                            List <Proyecto> proyectos=consulta2.list();

                            request.setAttribute("resultado1",programadores);
                            request.setAttribute("resultado2",proyectos);

                            sesion.getTransaction().commit();

                            request.getRequestDispatcher("rTarea.jsp").forward(request, response);
                            
                            }finally{
                                sesion.close();
                            }
         }else{
               if(action.equals("registrar")){
           
                   try {  //para fecha
                       int id_programador=Integer.parseInt(request.getParameter("programador"));
                       int id_proyecto=Integer.parseInt(request.getParameter("proyecto"));
                       int duracion=Integer.parseInt(request.getParameter("duracion"));
                       
                       
                     //  response.getWriter().print(""+id_programador+""+id_proyecto);
                       DateFormat formatter = new SimpleDateFormat("Y-M-D");
                       Date fecha=formatter.parse(request.getParameter("fecha"));
                       
                       
                       SessionFactory sf=HibernateUtil.getSessionFactory();
                       Session sesion=sf.openSession();
                       sesion.beginTransaction();
                       
                       Programador programador=(Programador)sesion.get(Programador.class,id_programador);
                       Proyecto proyecto =(Proyecto)sesion.get(Proyecto.class,id_proyecto);
                       
                       
                       //salario base del trabajador
                       int salarioBase=programador.getSalarioBase();
                       
                       Tarea tarea=new Tarea(programador,proyecto, duracion, fecha);
                       tarea.calcularCosto(duracion, salarioBase); //calculo el costo de la tarea
                       
                       sesion.save(tarea);
                       
                       sesion.getTransaction().commit();
                       
                       sesion.close();                       
                       request.getRequestDispatcher("rTarea.jsp").forward(request, response);
                       
                       
                   } catch (ParseException ex) {
                       Logger.getLogger(servlet_Tarea.class.getName()).log(Level.SEVERE, null, ex);
                   }

           
            }else{
                  if(action.equals("consultar")){
                      
                      SessionFactory sf=HibernateUtil.getSessionFactory();
                      Session sesion=sf.openSession();
                      sesion.beginTransaction();
                      
                      try{
                          //hql
                          
                          Query query=sesion.createQuery("FROM Tarea");
                          List <Tarea> tareas =query.list();
                          
                          request.setAttribute("resultado", tareas);
                          
                          sesion.getTransaction().commit();
                        
                          request.getRequestDispatcher("cTarea.jsp").forward(request, response);
                          
                      }finally{
                          sesion.close();
                      }
                      

                 }else{
                          if(action.equals("atualizar")){

                         }
                 }
            }
        
             
         }
            
          
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
