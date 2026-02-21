package hotel.uz.hotel.service;

import hotel.uz.hotel.dto.request.RoomBookingGuestAddRequestDto;
import hotel.uz.hotel.dto.request.RoomBookingReceptionistRequestDto;
import hotel.uz.hotel.dto.response.RoomBookingCheckInResponseDto;
import hotel.uz.hotel.dto.response.RoomBookingResponseDto;

public interface RoomBookingService {
    RoomBookingResponseDto createGuest(RoomBookingGuestAddRequestDto dto);

    RoomBookingCheckInResponseDto checkIn(RoomBookingReceptionistRequestDto dto);
}
