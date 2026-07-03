package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Hotel;
import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelNamePageResponseDto;
import hotel.uz.hotel.dto.response.HotelResponseDto;
import hotel.uz.hotel.repository.HotelRepository;
import hotel.uz.hotel.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public HotelResponseDto add(HotelAddRequestDto dto) {
        if (!StringUtils.hasText(dto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name must not be null or empty ");
        }

        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());

        hotelRepository.save(hotel);
        return HotelResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .build();
    }

    @Override
    public HotelResponseDto update(HotelUpdateRequestDto dto) {
        if (dto.getId()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Hotel ID must not be null");
        }

        Hotel hotel = hotelRepository.findById(dto.getId())
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found with id: " + dto.getId()));

        if (!StringUtils.hasText(dto.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name must not be null or empty");
        }
        hotel.setName(dto.getName());
        hotelRepository.save(hotel);
        return HotelResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .build();
    }

    @Override
    public HotelNamePageResponseDto<Hotel> getPageName(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page,size);
        Page<Hotel> hotelPage = hotelRepository.findByNameContainingIgnoreCase(name,pageable);
        return new HotelNamePageResponseDto<>(
                hotelPage.getContent(),
                hotelPage.getNumber(),
                hotelPage.getTotalPages(),
                hotelPage.getTotalElements(),
                hotelPage.getSize());
    }

    @Override
    public HotelResponseDto getId(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found with id: " + id));

        return HotelResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .build();
    }

    @Override
    public void delete(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found with id: " + id));

        hotelRepository.delete(hotel);
    }

    @Override
    public HotelNamePageResponseDto<Hotel> getHotel(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                :Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
        return new HotelNamePageResponseDto<>(
                hotelPage.getContent(),
                hotelPage.getNumber(),
                hotelPage.getTotalPages(),
                hotelPage.getTotalElements(),
                hotelPage.getSize());
    }


}
