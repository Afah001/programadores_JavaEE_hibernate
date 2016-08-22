/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.HibernateUtil;
import modelo.Programador;
import modelo.Proyecto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author FRAGATA
 */
public class servlet_Proyecto extends HttpServlet {

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
            
            if(action.equals("registrar")){
           
           String nombre=request.getParameter("nombre");
           int duracion=Integer.parseInt(request.getParameter("duracion"));
           String cliente=request.getParameter("cliente");
        
           
           SessionFactory sf=HibernateUtil.getSessionFactory();
           Session sesion=sf.openSession();
           sesion.beginTransaction();
           
           Proyecto proyecto=new Proyecto(nombre,duracion,cliente);
          
           sesion.save(proyecto);
           sesion.getTransaction().commit();
           
           sesion.close();
           
           request.getRequestDispatcher("rProyecto.jsp").forward(request, response);
           
           
       }else{
             if(action.equals("consultar")){
                     SessionFactory sf=HibernateUtil.getSessionFactory();
                     Session sesion=sf.openSession();
                    
                    try{ //el try -> para q muestre las citas programadas antes de cerrar sesion
                        sesion.beginTransaction();

                        //CONSULTAR CON HQL
                        Query query=sesion.createQuery("FROM Proyecto");
                        List <Proyecto> proyectos=query.list();     //tomamos la lista de odontologos consultados

                        //ITERO PARA COSULTAR EL COSTO TOTAL DE CADA PROYECTO
                        for(Proyecto p: proyectos){
                            
                            p.setCostoTotal(p.getTareas());
                            
                        }
                        
                        request.setAttribute("resultado",proyectos);  //llevamos la lista de odontologo de la forma request

                        sesion.getTransaction().commit(); 
                        
                        request.getRequestDispatcher("cProyecto.jsp").forward(request, response);
                      
                        
                    }finally{
                        sesion.close();
                    }
            }else{
                     if(action.equals("atualizar")){
       
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
