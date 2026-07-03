package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.filter.HouseKeeperFilterDTO;
import hotel.uz.hotel.dto.response.HouseKeeperResponseDto;

import java.util.List;

public interface HouseKeeperService {


    List<HouseKeeperResponseDto> filter(HouseKeeperFilterDTO filterDTO);
}
