/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author int303
 */
public class ShowHeaderServlet extends HttpServlet {

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
        String browser = request.getHeader("User-Agent");
        
        Enumeration<String> en = request.getHeaderNames();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowHeaderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HTTP Header :: </h1><hr>");
            out.println("<table><tr style='background-color:#CCCCCC'><td>Header Name</td><td>Value(s)</td></tr>");
            out.println("<tr><td align='right'>Requested Browser:</td>");
            while(en.hasMoreElements()){
                String headerName = en.nextElement();
                out.println("<tr><td align='right'>"+headerName+":</td>");
                Enumeration<String> headerValues = request.getHeaders(headerName);
                int count=1;
                while(headerValues.hasMoreElements()){
                    String value = headerValues.nextElement();
                    out.println(count>1?"<tr><td></td>":"");
                    out.println("<td>"+value+"</td></tr>");
                }
            }    
            out.println("<tr><td align='right'>Remote IP Address: </td>");
            out.println("<td>"+request.getRemoteAddr()+"</td></tr>"); 
            out.println("<tr><td align='right'>Requrse URI: </td>");
            out.println("<td>"+request.getRequestURI()+"</td></tr>"); //เอกสารที่clientเรียก
            out.println("<tr><td align='right'>Requrse protocol: </td>");
            out.println("<td>"+request.getMethod()+"</td></tr>"); 
            out.println("<tr><td align='right'>HTTP Level: </td>");
            out.println("<td>"+request.getProtocol()+"</td></tr>"); 
            out.println("<tr><td align='right'>Requrse Session ID: </td>");
            out.println("<td>"+request.getRequestedSessionId()+"</td></tr>"); 
            request.getSession();
            //out.println("<td>"+browser+"</td></tr>");
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
