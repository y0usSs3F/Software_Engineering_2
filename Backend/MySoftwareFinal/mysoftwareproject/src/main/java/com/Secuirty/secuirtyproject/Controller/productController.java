package com.Secuirty.secuirtyproject.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Secuirty.secuirtyproject.Entities.product;
import com.Secuirty.secuirtyproject.Services.productService;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> saveProduct(@RequestParam("file") MultipartFile file, @RequestParam Map<String, String> request) {
        try {
            if (!request.containsKey("productName") || request.get("productName").trim().isEmpty() ||
                    !request.containsKey("description") || request.get("description").trim().isEmpty() ||
                    !request.containsKey("price") || request.get("price").trim().isEmpty() ||
                    !request.containsKey("warehouseId") || request.get("warehouseId").trim().isEmpty()) {
                return ResponseEntity.badRequest().body(
                        "Error: Missing or empty required fields. Please ensure 'productName', 'description', 'price', and 'warehouseId' are provided.");
            }
            if (file == null || file.isEmpty()) {
                return ResponseEntity.badRequest().body("Error: File is empty or null.");
            }

            String productName = request.get("productName");
            String description = request.get("description");

            int price;
            int warehouseId;
            try {
                price = Integer.parseInt(request.get("price"));
                warehouseId = Integer.parseInt(request.get("warehouseId"));
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(
                        "Error: Invalid input format for 'price' or 'warehouseId'. Please enter valid numbers.");
            }

            product product = new product(productName, description, price, warehouseId);

            // Handle photo upload
            try {
                product.setPhoto(file.getBytes());
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error: Failed to upload photo.");
            }

            productService.addProduct(product);

            return ResponseEntity.ok("Product added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: An unexpected error occurred.");
        }
    }

    // delete medicine
    @DeleteMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "Deleted successfully";
    }

    // update medicine
    @PutMapping("/{id}/update")

    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        try {
            if (!request.containsKey("productName") || request.get("productName").trim().isEmpty() ||
                    !request.containsKey("productDescription") || request.get("productDescription").trim().isEmpty()
                    ||
                    !request.containsKey("productPrice") || request.get("productPrice").trim().isEmpty() ||
                    !request.containsKey("warehouseId") || request.get("warehouseId").trim().isEmpty()) {
                return ResponseEntity.badRequest().body(
                        "Error: Missing or empty required fields. Please ensure 'productName', 'productDescription', 'productPrice', and 'warehouseId' are provided.");
            }

            String productName = request.get("productName");
            String description = request.get("productDescription");

            int price;
            int warehouseId;
            try {
                price = Integer.parseInt(request.get("productPrice"));
                warehouseId = Integer.parseInt(request.get("warehouseId"));
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(
                        "Error: Invalid input format for 'productPrice' or 'warehouseId'. Please enter valid numbers.");
            }

            product product = new  product( productName, description, price, warehouseId);
            product updatedProduct = productService.updateProduct(product);
            if (updatedProduct != null) {
                return ResponseEntity.ok("Product updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Error: Product with ID " + id + " not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: An unexpected error occurred.");
        }
    }
    // read (view) product
    @GetMapping("/read")
    public List<product> getProducts() {
        return productService.getProducts();
    }

    // search by name
    @GetMapping("/search")
    public ResponseEntity<List<product>> searchProductByName(@RequestParam String name) {
        try {
            List<product> products = productService.searchByName(name);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
