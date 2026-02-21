package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelResponseDto;

public interface HotelService {
    HotelResponseDto add(HotelAddRequestDto dto);

    HotelResponseDto update(HotelUpdateRequestDto dto);

    HotelResponseDto getName(String name);

    HotelResponseDto getId(Long id);

    void delete(Long id);
}
