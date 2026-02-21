package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.RoomKey;
import hotel.uz.hotel.dto.request.RoomKeyAddRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveMasterRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveUserRequestDto;
import hotel.uz.hotel.dto.response.RoomKeyPageResponseDto;
import hotel.uz.hotel.dto.response.RoomKeyResponseDto;
import hotel.uz.hotel.service.RoomKeyService;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api/room/key")
public class RoomKeyController {
    private final RoomKeyService roomKeyService;

    public RoomKeyController(RoomKeyService roomKeyService) {
        this.roomKeyService = roomKeyService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomKeyResponseDto> create(@RequestBody RoomKeyAddRequestDto dto){
        return ResponseEntity.ok(roomKeyService.assignRoom(dto));
    }
    @PutMapping("/active")
    public ResponseEntity<Boolean> active(@RequestBody RoomKeyUpdateActiveUserRequestDto dto) throws BadRequestException {
        return ResponseEntity.ok(roomKeyService.userActive(dto));
    }

    @PutMapping("/active/master")
    public ResponseEntity<Boolean> activeMaster(@RequestBody RoomKeyUpdateActiveMasterRequestDto dto) throws BadRequestException {
        return ResponseEntity.ok(roomKeyService.masterActive(dto));
    }

    @GetMapping("/pagination/hibernate")
    public ResponseEntity<RoomKeyPageResponseDto<RoomKey>> getHibernate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(roomKeyService.pageHibernate(page,size));
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<RoomKey>> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(roomKeyService.page(page,size));
    }

    @DeleteMapping("/delete/{keyId}")
    public ResponseEntity<Void> delete(@PathVariable String keyId){
        roomKeyService.delete(keyId);
        return ResponseEntity.ok().build();
    }















}
