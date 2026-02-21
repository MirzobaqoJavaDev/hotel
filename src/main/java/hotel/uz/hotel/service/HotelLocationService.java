package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.request.HotelLocationAddRequestDto;
import hotel.uz.hotel.dto.request.HotelLocationUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelLocationResponseDto;

public interface HotelLocationService {
    HotelLocationResponseDto add(HotelLocationAddRequestDto dto);

    HotelLocationResponseDto update(HotelLocationUpdateRequestDto dto);

    HotelLocationResponseDto getName(String name);

    HotelLocationResponseDto getId(Long id);

    void delete(Long id);
}
