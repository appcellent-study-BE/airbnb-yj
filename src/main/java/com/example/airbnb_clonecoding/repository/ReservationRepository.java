package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}