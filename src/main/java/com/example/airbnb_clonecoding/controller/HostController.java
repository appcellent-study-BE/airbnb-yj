package com.example.airbnb_clonecoding.controller;

import com.example.airbnb_clonecoding.dto.ResponseDto;
import com.example.airbnb_clonecoding.dto.RoomDto;
import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.service.HostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {

        this.hostService = hostService;
    }

    // 호스트 등록
    @PostMapping("become-a-host")
    public ResponseDto<Object> becomeHost(@RequestBody int userId) {

        hostService.becomeHost(userId);

        return ResponseDto.success("host success", null);
    }

    // 숙소 등록
    @PostMapping("/host/homes")
    public ResponseDto<Object> registerHome(@RequestBody RoomDto roomDto) {

        hostService.registerHome(roomDto.getHostId(), roomDto);
        return ResponseDto.success("home success", null);
    }
}