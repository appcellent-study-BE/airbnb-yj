package com.example.airbnb_clonecoding.repository;

import com.example.airbnb_clonecoding.model.Host;
import com.example.airbnb_clonecoding.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostRepository extends JpaRepository<Host, Integer> {
    Optional<Host> findByUserId(Member user);
}