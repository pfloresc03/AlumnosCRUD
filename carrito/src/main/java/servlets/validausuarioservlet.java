/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pablo Flores
 */
public class validausuarioservlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validausuarioservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validausuarioservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
        PrintWriter out = response.getWriter();

        //Simulando valores
        String usuarioCorrecto = "Juan";
        String passCorrecto = "123";

        String pUsuario = request.getParameter("usuario");
        String pPassword = request.getParameter("password");

        if (usuarioCorrecto.equals(pUsuario) && passCorrecto.equals(pPassword)) {
            out.println("<h1>");
            out.println("Datos correctos");
            out.println("<br>Usuario:" + pUsuario);
            out.println("<br>Password:" + pPassword);
            out.println("</h1>");
        } else {
            //Respondemos al navegador con un codigo de estado de No Autorizado
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }

        //Listado de codigos de error
        //http://docstore.mik.ua/orelly/java-ent/servlet/appc_01.htm
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
