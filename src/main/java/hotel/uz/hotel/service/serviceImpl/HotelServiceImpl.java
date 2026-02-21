package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Hotel;
import hotel.uz.hotel.dto.request.HotelAddRequestDto;
import hotel.uz.hotel.dto.request.HotelUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelResponseDto;
import hotel.uz.hotel.repository.HotelRepository;
import hotel.uz.hotel.service.HotelService;
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
    public HotelResponseDto getName(String name) {
        Hotel hotel = hotelRepository.findByName(name)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found with name: " + name));

        return HotelResponseDto.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .build();
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
        Hotel hotel = hotelRepository.findById(Long.valueOf(id))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found with id: " + id));

        hotelRepository.delete(hotel);
    }


}
