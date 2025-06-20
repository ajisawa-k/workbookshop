package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductLogic;

@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ProductDetail() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set character encoding
        request.setCharacterEncoding("UTF-8");
        
        // Get product ID parameter
        String productId = request.getParameter("p_id");
        
        // Find product by ID
        ProductLogic productLogic = new ProductLogic();
        Product product = null;
        
        if (productId != null && !productId.trim().isEmpty()) {
            product = productLogic.findProductById(productId.trim());
        }
        
        // Set product as request attribute (null if not found)
        request.setAttribute("product", product);
        
        // Forward to product detail JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/product-detail.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Handle any POST operations if needed
        // For now, just delegate to GET
        doGet(request, response);
    }
}