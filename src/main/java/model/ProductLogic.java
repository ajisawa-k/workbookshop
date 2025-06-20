package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class ProductLogic {
    
    public List<Product> findALLProducts() {
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.findAllProducts();
        
        // Fallback to sample data if database is not available
        if (products == null || products.isEmpty()) {
            products = new ArrayList<>();
            products.add(new Product("1", "ノート", 120));
            products.add(new Product("2", "ペン", 80));
            products.add(new Product("3", "消しゴム", 60));
            products.add(new Product("4", "定規", 150));
            products.add(new Product("5", "ファイル", 200));
            System.out.println("Warning: Database connection failed, using sample data");
        }
        
        return products;
    }
    
    /**
     * Search products by name (case-insensitive partial match)
     */
    public List<Product> searchProducts(String searchTerm) {
        List<Product> allProducts = findALLProducts();
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return allProducts;
        }
        
        List<Product> filteredProducts = new ArrayList<>();
        String searchLower = searchTerm.trim().toLowerCase();
        
        for (Product product : allProducts) {
            if (product.getP_name().toLowerCase().contains(searchLower)) {
                filteredProducts.add(product);
            }
        }
        
        return filteredProducts;
    }
    
    /**
     * Find a product by its ID
     */
    public Product findProductById(String productId) {
        List<Product> allProducts = findALLProducts();
        
        if (productId == null || productId.trim().isEmpty()) {
            return null;
        }
        
        for (Product product : allProducts) {
            if (product.getP_id().equals(productId)) {
                return product;
            }
        }
        
        return null;
    }
}