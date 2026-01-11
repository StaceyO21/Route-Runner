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
public class Products {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private String description;

    @Lob
    @Column(name = "profile_picture_data", columnDefinition = "LONGBLOB")
    private byte[] profilePictureData;

    public String getProfilePictureBase64() {
        if (this.profilePictureData != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.profilePictureData);
        }
        return null;
    }
}
