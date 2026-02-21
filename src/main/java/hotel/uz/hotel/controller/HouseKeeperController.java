package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.HouseKeeper;
import hotel.uz.hotel.dto.response.HouseKeeperPageHibernateResponseDto;
import hotel.uz.hotel.service.HouseKeeperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/house/keeper")
public class HouseKeeperController {

    private final HouseKeeperService houseKeeperService;

    public HouseKeeperController(HouseKeeperService houseKeeperService) {
        this.houseKeeperService = houseKeeperService;
    }

    @GetMapping("/all/page")
    private ResponseEntity<HouseKeeperPageHibernateResponseDto<HouseKeeper>> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(houseKeeperService.pageHibernate(page,size));
    }





}
