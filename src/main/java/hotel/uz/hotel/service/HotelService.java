package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.Hotel;
import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelNamePageResponseDto;
import hotel.uz.hotel.dto.response.HotelResponseDto;
import org.springframework.data.domain.Page;

public interface HotelService {
    HotelResponseDto add(HotelAddRequestDto dto);

    HotelResponseDto update(HotelUpdateRequestDto dto);

    HotelNamePageResponseDto<Hotel> getPageName(String name, int page, int size);

    HotelResponseDto getId(Long id);

    void delete(Long id);

    HotelNamePageResponseDto<Hotel> getHotel(int page, int size, String sortBy, String direction);
}
