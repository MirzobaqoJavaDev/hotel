package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelResponseDto;
import hotel.uz.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<HotelResponseDto> add(@RequestBody HotelAddRequestDto dto){
        return ResponseEntity.ok(hotelService.add(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<HotelResponseDto> update(@RequestBody HotelUpdateRequestDto dto){
        return ResponseEntity.ok(hotelService.update(dto));
    }
    @GetMapping("/{name}")
    public ResponseEntity<HotelResponseDto> getName(@PathVariable String name){
        return ResponseEntity.ok(hotelService.getName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDto> getId(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        hotelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
