package com.example.airbnb_clonecoding.controller;

import com.example.airbnb_clonecoding.dto.ResponseDto;
import com.example.airbnb_clonecoding.dto.RoomDetailDto;
import com.example.airbnb_clonecoding.service.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {

        this.roomService = roomService;
    }

    @GetMapping("/rooms/{roomId}")
    public ResponseDto<Object> roomDetail(@PathVariable int roomId) {

        RoomDetailDto roomDto = roomService.roomDetail(roomId);
        return ResponseDto.success("room success", roomDto);
    }
}