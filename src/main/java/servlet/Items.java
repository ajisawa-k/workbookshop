package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductLogic;

@WebServlet("/Items")
public class Items extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Items() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get search parameter
        String searchTerm = request.getParameter("search");
        
        // Get products based on search term
        ProductLogic productLogic = new ProductLogic();
        List<Product> productList;
        
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            // Search for products
            productList = productLogic.searchProducts(searchTerm);
        } else {
            // Get all products
            productList = productLogic.findALLProducts();
        }
        
        // Set products as request attribute
        request.setAttribute("productList", productList);
        
        // Forward to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/items.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Handle add to cart functionality
        String add2cart = request.getParameter("add2cart");
        
        if (add2cart != null) {
            // Handle cart operations here
            // This would typically involve:
            // 1. Getting cart from session
            // 2. Adding item to cart
            // 3. Saving cart back to session
            // For now, just redirect back to items page to display the cart
        }
        
        // Redirect to GET to refresh the page
        response.sendRedirect("Items");
    }
}