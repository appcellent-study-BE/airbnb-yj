package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity
public class WishlistFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_FOLDER_ID")
    private int wishlistFolderId;

    @ManyToOne
    private Member userId;

    @Column(length = 20)
    private String wishlistName;
}