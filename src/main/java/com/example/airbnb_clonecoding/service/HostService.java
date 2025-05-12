package com.example.airbnb_clonecoding.service;

import com.example.airbnb_clonecoding.dto.RoomDto;
import com.example.airbnb_clonecoding.model.Host;
import com.example.airbnb_clonecoding.model.Member;
import com.example.airbnb_clonecoding.model.Room;
import com.example.airbnb_clonecoding.repository.MemberRepository;
import com.example.airbnb_clonecoding.repository.HostRepository;
import com.example.airbnb_clonecoding.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HostService {

    private final MemberRepository memberRepository;
    private final HostRepository hostRepository;
    private final RoomRepository roomRepository;

    public HostService(MemberRepository memberRepository,
                       HostRepository hostRepository,
                       RoomRepository roomRepository) {

        this.memberRepository = memberRepository;
        this.hostRepository = hostRepository;
        this.roomRepository = roomRepository;
    }

    // 호스트 등록
    public void becomeHost(int userId) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No User"));

        if (member.isHost()) {
            throw new IllegalStateException("Already Host");
        }

        // Member의 isHost 필드를 true로 변경
        member.setHost(true);
        memberRepository.save(member);

        // 호스트 생성
        Host host = Host.builder()
                .userId(member)
                .hostDate(LocalDate.now())
                .isEmail(member.isCertificate())
                .isPhoneNum(member.isCertificate())
                .build();

        hostRepository.save(host);
    }

    // 숙소 등록
    public void registerHome(int userId, RoomDto roomDto) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No User"));

        Host host = hostRepository.findByUserId(member)
                .orElseThrow(() -> new IllegalArgumentException("No Host"));

        // 숙소 생성
        Room room = Room.builder()
                .hostId(host)
                .roomName(roomDto.getRoomName())
                .roomDscrptn(roomDto.getRoomDscrptn())
                .roomAddress(roomDto.getRoomAddress())
                .roomLocation(roomDto.getRoomLocation())
                .roomAdultMax(roomDto.getRoomAdultMax())
                .roomChildrenMax(roomDto.getRoomChildMax())
                .roomPetMax(roomDto.getRoomPetMax())
                .bedroomNum(roomDto.getBedroomNum())
                .bathroomNum(roomDto.getBathroomNum())
                .roomPrice(roomDto.getRoomPrice())
                .checkInTime(roomDto.getCheckInTime())
                .checkOutTime(roomDto.getCheckOutTime())
                .build();

        roomRepository.save(room);
    }
}