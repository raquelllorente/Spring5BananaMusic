package com.bananaapps.bananamusic.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Integer id;

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public User(Integer id) {
        this.id = id;
    }


}