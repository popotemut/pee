/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.int303.practice.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sit.int303.practice.model.Product;

/**
 *
 * @author INT303
 */
public class SearchProductServlet extends HttpServlet {

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
        String searchCategory = request.getParameter("searchCategory");
        String searchText1 = request.getParameter("searchText1");
        String target = "/ProductListing.jsp";
        if (searchText1 == null || searchText1.trim().length() == 0) {
            request.setAttribute("message", "");
        } else {
            if (searchCategory.equalsIgnoreCase("price")) {
                String searchText2 = request.getParameter("searchText2");
                try {
                    double lower = Double.parseDouble(searchText1);
                    double upper = Double.parseDouble(searchText2);
                    List<Product> products = Product.findByPrice(lower, upper);
                    if (products == null) {
                        request.setAttribute("message", "Products for specific price does not exist !!");
                    }
                    request.getSession().setAttribute("products", products); // put products to session scope
                } catch (Exception e) {
                    request.setAttribute("message", "Please enter price range with decimal number ONLY !!!");
                }
            } else if (searchCategory.equalsIgnoreCase("name")) {
                List<Product> products = Product.findByName(searchText1);
                if (products == null) {
                    request.setAttribute("message", "Products for specific name does not exist !!");
                }
                request.getSession().setAttribute("products", products);   // put products to session scope

            } else {
                target = "/ProductDetail.jsp";
                Product p = Product.findById(Integer.parseInt(searchText1));
                if (p == null) {
                    request.setAttribute("message", "Product id " + searchText1 + "  does not exist !!");
                }
                request.getSession().setAttribute("p", p);
            }
        }

        getServletContext()
                .getRequestDispatcher(target).forward(request, response);
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
