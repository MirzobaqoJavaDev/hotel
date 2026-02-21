package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonAddRequestDto;
import hotel.uz.hotel.dto.request.PersonUpdateRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;
import hotel.uz.hotel.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }
    @PostMapping("/create/guest")
    public ResponseEntity<PersonResponseDto> create(@RequestBody PersonAddRequestDto dto){
        return ResponseEntity.ok(guestService.createGuest(dto));
    }

    @PutMapping("/update/guest")
    public ResponseEntity<PersonResponseDto> updateGuest(@RequestBody PersonUpdateRequestDto dto){
        return ResponseEntity.ok(guestService.updateGuest(dto));
    }

    @GetMapping("/guest/all")
    public ResponseEntity<PersonPageResponseDto<Person>> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(guestService.pageGuest(page,size));
    }
}
