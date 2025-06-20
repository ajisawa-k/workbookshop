package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Product;
import model.ProductLogic;
import model.Cart;
import model.CartLogic;

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
        
        // Set character encoding
        request.setCharacterEncoding("UTF-8");
        
        // Handle add to cart functionality
        String add2cart = request.getParameter("add2cart");
        
        if (add2cart != null) {
            // Get cart parameters
            String p_id = request.getParameter("p_id");
            String p_name = request.getParameter("p_name");
            String priceStr = request.getParameter("price");
            String countStr = request.getParameter("count");
            
            if (p_id != null && p_name != null && priceStr != null && countStr != null) {
                try {
                    Integer price = Integer.parseInt(priceStr);
                    Integer count = Integer.parseInt(countStr);
                    
                    if (count > 0) {
                        // Create cart item
                        Cart newCart = new Cart(p_id, p_name, price, count);
                        
                        // Get session and cart list
                        HttpSession session = request.getSession();
                        @SuppressWarnings("unchecked")
                        List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
                        
                        // Add to cart
                        CartLogic cartLogic = new CartLogic();
                        cartList = cartLogic.add2Cart(newCart, cartList);
                        
                        // Save cart to session
                        session.setAttribute("cartList", cartList);
                    }
                } catch (NumberFormatException e) {
                    // Invalid number format, ignore
                }
            }
        }
        
        // Redirect to GET to refresh the page
        response.sendRedirect("Items");
    }
}