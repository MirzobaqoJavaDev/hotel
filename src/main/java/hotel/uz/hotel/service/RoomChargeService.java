package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.request.AmenityAddRequestDto;
import hotel.uz.hotel.dto.response.AmenityResponseDto;

public interface RoomChargeService {
    AmenityResponseDto addAmenity(AmenityAddRequestDto dto);
}
