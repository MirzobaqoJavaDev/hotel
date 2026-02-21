package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonAddRequestDto;
import hotel.uz.hotel.dto.request.PersonUpdateRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;

public interface GuestService {
    PersonResponseDto createGuest(PersonAddRequestDto dto);

    PersonResponseDto updateGuest(PersonUpdateRequestDto dto);

    PersonPageResponseDto<Person> pageGuest(int page, int size);
}
