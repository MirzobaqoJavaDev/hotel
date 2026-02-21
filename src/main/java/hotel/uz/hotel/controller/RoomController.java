package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.request.RoomAddRequestDto;
import hotel.uz.hotel.dto.request.RoomUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomResponseDto;
import hotel.uz.hotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomResponseDto> add(@RequestBody RoomAddRequestDto dto){
        return ResponseEntity.ok(roomService.add(dto));
    }
    @PutMapping("/update")
    public ResponseEntity<RoomResponseDto> update(@RequestBody RoomUpdateRequestDto dto){
        return ResponseEntity.ok(roomService.update(dto));
    }
    @GetMapping("/{name}")
    public ResponseEntity<RoomResponseDto> getName(@PathVariable String name){
        return ResponseEntity.ok(roomService.getName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDto> getId(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        roomService.delete(id);
        return ResponseEntity.ok().build();
    }
}
