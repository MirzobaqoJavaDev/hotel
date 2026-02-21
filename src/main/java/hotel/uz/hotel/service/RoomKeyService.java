package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.RoomKey;
import hotel.uz.hotel.dto.request.RoomKeyAddRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveMasterRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveUserRequestDto;
import hotel.uz.hotel.dto.response.RoomKeyPageResponseDto;
import hotel.uz.hotel.dto.response.RoomKeyResponseDto;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;

public interface RoomKeyService {
    RoomKeyResponseDto assignRoom(RoomKeyAddRequestDto dto);

    Boolean userActive(RoomKeyUpdateActiveUserRequestDto dto) throws BadRequestException;

    Boolean masterActive(RoomKeyUpdateActiveMasterRequestDto dto) throws BadRequestException;

    RoomKeyPageResponseDto<RoomKey> pageHibernate(int page, int size);

    Page<RoomKey> page(int page, int size);

    void delete(String keyId);
}
