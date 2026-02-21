package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.request.HotelLocationAddRequestDto;
import hotel.uz.hotel.dto.request.HotelLocationUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelLocationResponseDto;
import hotel.uz.hotel.service.HotelLocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel/location")
public class HotelLocationController {
    private final HotelLocationService hotelLocationService;

    public HotelLocationController(HotelLocationService hotelLocationService) {
        this.hotelLocationService = hotelLocationService;
    }
    @PostMapping("/create")
    public ResponseEntity<HotelLocationResponseDto> add(@RequestBody HotelLocationAddRequestDto dto){
        return ResponseEntity.ok(hotelLocationService.add(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<HotelLocationResponseDto> update(@RequestBody HotelLocationUpdateRequestDto dto){
        return ResponseEntity.ok(hotelLocationService.update(dto));
    }
    @GetMapping("/{name}")
    public ResponseEntity<HotelLocationResponseDto> getName(@PathVariable String name){
        return ResponseEntity.ok(hotelLocationService.getName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelLocationResponseDto> getId(@PathVariable Long id) {
        return ResponseEntity.ok(hotelLocationService.getId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hotelLocationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
