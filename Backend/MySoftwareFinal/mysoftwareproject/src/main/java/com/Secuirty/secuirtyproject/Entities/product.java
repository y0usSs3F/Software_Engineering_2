package com.Secuirty.secuirtyproject.Entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import com.Secuirty.secuirtyproject.Entities.warehouse;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    Integer productId;

    @Column(name="product_name")
    String productName;

    @Column(name="product_description")
    String description;

    @Column(name="product_price")
    Integer price;
    @Column(name="warehouseId")
    Integer warehouse;

    // New field for storing photo
    @Lob
    @Column(name="product_photo", columnDefinition = "BLOB")
    private byte[] photo;

    // Transient field to hold photo file during request processing
    @Transient
    private MultipartFile photoFile;

    // @ManyToOne
    // @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    // category category;

    public product(String productName, String description, int price, int warehouseId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.warehouse = warehouseId;
    }
}




