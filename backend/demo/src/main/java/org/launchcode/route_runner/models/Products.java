package org.launchcode.route_runner.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Products extends AbstractEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String description;

    @Lob
    @Column(name = "product_picture_data", columnDefinition = "LONGBLOB")
    private byte[] productPictureData;

    public String getProductPictureBase64() {
        if (this.productPictureData != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.profilePictureData);
        }
        return null;
    }
}
