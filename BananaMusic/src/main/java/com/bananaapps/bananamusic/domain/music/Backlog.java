package com.bananaapps.bananamusic.domain.music;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "inventory")
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long id;
    @NotBlank
    private String location;
    @Min(1)
    private int quantity;
    @Min(1)
    private int version;
    @ManyToOne
    @JoinColumn(name = "tune_id")
    private Song item;

    public Backlog(String location, int quantity) {
        // Set the location and quantity
        setLocation(location);
        setQuantity(quantity);
    }

}
