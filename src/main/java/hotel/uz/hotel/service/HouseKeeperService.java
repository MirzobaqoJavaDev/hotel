package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.HouseKeeper;
import hotel.uz.hotel.dto.request.HouseKeeperAssignRequestDto;
import hotel.uz.hotel.dto.request.HouseKeeperAssignUpdateRequestDto;
import hotel.uz.hotel.dto.response.HouseKeeperPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.HouseKeeperResponseDto;

public interface HouseKeeperService {

    HouseKeeperPageHibernateResponseDto<HouseKeeper> pageHibernate(int page, int size);
}
