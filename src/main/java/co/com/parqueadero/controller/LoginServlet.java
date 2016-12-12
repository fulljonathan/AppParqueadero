/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parqueadero.controller;

import co.com.parqueadero.entities.Tblusuarios;
import co.com.parqueadero.jpacontroller.TblusuariosJpaController;
import co.com.parqueadero.util.JPAFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sala304
 */
public class LoginServlet extends HttpServlet {

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
  
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;
        
        String usuario = request.getParameter("txtUsuario");
        String clave  = request.getParameter("txtClave");
        
        Tblusuarios tblusuarios = null;
        
        TblusuariosJpaController jpaController = new TblusuariosJpaController(JPAFactory.getFACTORY());
        
        //tblusuarios = jpaController.findTblusuarios(usuario);
        tblusuarios = jpaController.findTblusuarios(usuario, clave);
        
        //if (usuario.equals("admin") && clave.equals("admin")){
        if (tblusuarios!=null){
            rd = request.getRequestDispatcher("/view/ingreso.jsp");
        }else{
            rd = request.getRequestDispatcher("/error.jsp");
        }
        
        rd.forward(request, response);
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
