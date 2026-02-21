package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.request.RoomAddRequestDto;
import hotel.uz.hotel.dto.request.RoomUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomResponseDto;

public interface RoomService {
    RoomResponseDto add(RoomAddRequestDto dto);

    RoomResponseDto update(RoomUpdateRequestDto dto);

    RoomResponseDto getName(String name);

    RoomResponseDto getId(Long id);

    void delete(Long id);
}
