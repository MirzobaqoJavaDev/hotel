package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.RoomHouseKeeping;
import hotel.uz.hotel.dto.request.RoomHouseKeepingAddRequestDto;
import hotel.uz.hotel.dto.request.RoomHouseKeepingUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingResponseDto;
import hotel.uz.hotel.service.RoomHouseKeepingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room/house/keeping")
public class RoomHouseKeepingController {

    private final RoomHouseKeepingService roomHouseKeepingService;


    public RoomHouseKeepingController(RoomHouseKeepingService roomHouseKeepingService) {
        this.roomHouseKeepingService = roomHouseKeepingService;
    }

    @PostMapping("/create")
    private ResponseEntity<RoomHouseKeepingResponseDto> create(@RequestBody RoomHouseKeepingAddRequestDto dto){
        return ResponseEntity.ok(roomHouseKeepingService.create(dto));
    }

    @PutMapping("/update")
    private ResponseEntity<RoomHouseKeepingResponseDto> update(@RequestBody RoomHouseKeepingUpdateRequestDto dto){
        return ResponseEntity.ok(roomHouseKeepingService.update(dto));
    }

    @GetMapping("/all/page")
    private ResponseEntity<RoomHouseKeepingPageHibernateResponseDto<RoomHouseKeeping>> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(roomHouseKeepingService.pageHibernate(page,size));
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        roomHouseKeepingService.delete(id);
        return ResponseEntity.ok().build();
    }

}
