package org.launchcode.route_runner.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    private String name;

    private String username;

    private String password;

    private String verifiedPassword;

    private String email;


}
