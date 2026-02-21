package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonEmployeeAddRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;

public interface PersonService {
    PersonResponseDto createEmployee(PersonEmployeeAddRequestDto dto);

    PersonPageResponseDto<Person> pageEmployee(int page, int size);

    void delete(Long id);

    PersonResponseDto id(Long id);

    PersonResponseDto updateEmployee(PersonEmployeeAddRequestDto dto);
}
