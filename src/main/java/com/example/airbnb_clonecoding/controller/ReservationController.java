package com.example.airbnb_clonecoding.controller;

import com.example.airbnb_clonecoding.dto.ReservationDto;
import com.example.airbnb_clonecoding.dto.ResponseDto;
import com.example.airbnb_clonecoding.service.ReservationService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class ReservationController {

    private final ReservationService reservationService;

    // 숙소 예약
    @PostMapping("/stays/{roomId}")
    public ResponseDto<ReservationDto> saveBook(@PathVariable int roomId,
                                                @RequestBody ReservationDto reservationDto) {

        reservationService.createReservation(roomId, reservationDto);

        return ResponseDto.success("숙소 예약 완료", null);
    }

    // 숙소 예약 취소
    @DeleteMapping("/{reservationId}")
    public ResponseDto<Void> cancelBook(@PathVariable int reservationId) {

        reservationService.cancelReservation(reservationId);

        return ResponseDto.success("숙소 예약 취소", null);
    }
}