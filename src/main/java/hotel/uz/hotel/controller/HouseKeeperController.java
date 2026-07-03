package hotel.uz.hotel.controller;

import hotel.uz.hotel.dto.filter.HouseKeeperFilterDTO;
import hotel.uz.hotel.dto.response.HouseKeeperResponseDto;
import hotel.uz.hotel.service.HouseKeeperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house/keeper")
public class HouseKeeperController {

    private final HouseKeeperService houseKeeperService;

    public HouseKeeperController(HouseKeeperService houseKeeperService) {
        this.houseKeeperService = houseKeeperService;
    }

    @GetMapping("/all")
    private ResponseEntity<List<HouseKeeperResponseDto>> filter(@ModelAttribute HouseKeeperFilterDTO filterDTO){
        return ResponseEntity.ok(houseKeeperService.filter(filterDTO));
    }





}
