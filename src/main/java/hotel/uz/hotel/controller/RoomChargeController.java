package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.request.AmenityAddRequestDto;
import hotel.uz.hotel.dto.response.AmenityResponseDto;
import hotel.uz.hotel.service.RoomChargeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room/charge")
public class RoomChargeController {
    private final RoomChargeService roomChargeService;

    public RoomChargeController(RoomChargeService roomChargeService) {
        this.roomChargeService = roomChargeService;
    }

    @PostMapping("/add/amenity")
    private ResponseEntity<AmenityResponseDto> addAmenity(@RequestBody AmenityAddRequestDto dto){
        return ResponseEntity.ok(roomChargeService.addAmenity(dto));
    }
}
