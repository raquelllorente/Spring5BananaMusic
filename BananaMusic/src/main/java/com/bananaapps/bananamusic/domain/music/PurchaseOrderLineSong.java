package com.bananaapps.bananamusic.domain.music;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PurchaseOrderLineSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineNumber;
    @OneToOne
    @JoinColumn(name = "song_id")
    private Song song;
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
