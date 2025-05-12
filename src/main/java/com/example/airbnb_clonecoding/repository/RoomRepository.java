package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
