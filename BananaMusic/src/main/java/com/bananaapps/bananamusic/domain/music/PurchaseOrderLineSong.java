package com.bananaapps.bananamusic.domain.music;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PurchaseOrderLineSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    private Long lineNumber;
    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;
    @Min(1)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;

    public PurchaseOrderLineSong(Long lineNumber, Song song, Integer quantity, Double unitPrice) {
        this.lineNumber = lineNumber;
        this.song = song;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    private Double unitPrice;


}
