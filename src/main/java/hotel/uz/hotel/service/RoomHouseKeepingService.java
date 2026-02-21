package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.RoomHouseKeeping;
import hotel.uz.hotel.dto.request.RoomHouseKeepingAddRequestDto;
import hotel.uz.hotel.dto.request.RoomHouseKeepingUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingResponseDto;

public interface RoomHouseKeepingService {
    RoomHouseKeepingResponseDto create(RoomHouseKeepingAddRequestDto dto);

    RoomHouseKeepingResponseDto update(RoomHouseKeepingUpdateRequestDto dto);

    RoomHouseKeepingPageHibernateResponseDto<RoomHouseKeeping> pageHibernate(int page, int size);

    void delete(Long id);
}
