package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.dto.ReservationDto;
import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.model.Reservation;
import com.example.airbnb_clonecoding.model.Room;
import com.example.airbnb_clonecoding.model.enums.ReservationStatus;
import com.example.airbnb_clonecoding.repository.MemberRepository;
import com.example.airbnb_clonecoding.repository.ReservationRepository;
import com.example.airbnb_clonecoding.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    // 예약 생성
    public void createReservation(int roomId, ReservationDto reservationDto) {

        Member user = memberRepository.findById(reservationDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("No User"));
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("No Room"));

        Reservation reservation = Reservation.builder()
                .userId(user)
                .roomId(room)
                .checkInDate(reservationDto.getCheckInDate())
                .checkOutDate(reservationDto.getCheckOutDate())
                .adults(reservationDto.getAdults())
                .children(reservationDto.getChildren())
                .infants(reservationDto.getInfants())
                .pets(reservationDto.getPets())
                .status(ReservationStatus.CONFIRMED)
                .build();

        reservationRepository.save(reservation);
    }

    // 예약 취소
    public void cancelReservation(int reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("No Reservation"));

        reservation.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.save(reservation);
    }
}