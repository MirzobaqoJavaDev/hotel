package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.Hotel;
import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelNamePageResponseDto;
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
    public ResponseEntity<HotelNamePageResponseDto<Hotel>>  getPageName(@PathVariable String name,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(hotelService.getPageName(name,page,size));
    }
    @GetMapping
    public ResponseEntity<HotelNamePageResponseDto<Hotel>> getHotel(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "5")int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction){
        return ResponseEntity.ok(hotelService.getHotel(page,size,sortBy,direction));
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
