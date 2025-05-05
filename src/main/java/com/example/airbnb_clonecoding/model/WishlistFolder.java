package com.example.airbnb_clonecoding.model;

import jakarta.persistence.*;

@Entity
public class WishlistFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISHLIST_FOLDER_ID")
    private Long wishlistFolderId;

    @ManyToOne
    private Member userId;

    private String wishlistName;
}