package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.request.RoomBookingReceptionistRequestDto;
import hotel.uz.hotel.dto.response.RoomBookingCheckInResponseDto;
import hotel.uz.hotel.dto.request.RoomBookingGuestAddRequestDto;
import hotel.uz.hotel.dto.response.RoomBookingResponseDto;
import hotel.uz.hotel.service.RoomBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room/booking")
public class RoomBookingController {

    private final RoomBookingService roomBookingService;

    public RoomBookingController(RoomBookingService roomBookingService) {
        this.roomBookingService = roomBookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomBookingResponseDto> createGuest(@RequestBody RoomBookingGuestAddRequestDto dto){
        return ResponseEntity.ok(roomBookingService.createGuest(dto));
    }

    @PutMapping("/update/checkIn")
    public ResponseEntity<RoomBookingCheckInResponseDto> createReceptionist(@RequestBody RoomBookingReceptionistRequestDto dto){
        return ResponseEntity.ok(roomBookingService.checkIn(dto));
    }


}
