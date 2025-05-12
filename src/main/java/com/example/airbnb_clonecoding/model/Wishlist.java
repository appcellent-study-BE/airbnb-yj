package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_ID")
    private int wishlistId;

    @ManyToOne
    private Room roomId;

    @ManyToOne
    private WishlistFolder wishilistFolderId;
}