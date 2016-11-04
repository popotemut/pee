/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.security.auth.message.callback.PrivateKeyCallback;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author int303
 */
public class Multiplication extends HttpServlet {
private String bg ="black";
private String fg ="white";

    @Override
    public void init() throws ServletException {
       String tmp=getInitParameter("background");
       if(tmp!=null){
           bg = tmp;
       }
       tmp=getInitParameter("foreground");
        if(tmp!=null){
            fg = tmp;
        }
    }
       
    

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
    }
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
        String nStr = request.getParameter("n");
        int n = 2;
        if(nStr != null){
            try {
                n = Integer.parseInt(nStr);
            } catch (Exception e) {
                n=2;
            }
            }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Multiplication</title>");            
            out.println("</head>");
            out.println("<body style='background-color:"+bg+";color:"+fg+"'>");
            out.println("<form action='mt' method = 'get'>");
            out.println("Enter number : ");
            out.println("<input type ='number' name ='n' value='"+n+"'required/>");
            out.println("<input type ='submit'/>");
            out.println("</form>");
            out.println("<table><tr><td colspan = 5>Multiplication table of "+n+"</td></tr>");
            for(int i=1;i<13;i++){
                out.println("<tr><td>"+n+"</td><td>x</td><td>"+i+"</td><td>=</td><td>"+(n*i)+"</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
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
