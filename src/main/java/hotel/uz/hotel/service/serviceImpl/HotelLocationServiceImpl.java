package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Address;
import hotel.uz.hotel.domain.Hotel;
import hotel.uz.hotel.domain.HotelLocation;
import hotel.uz.hotel.dto.request.HotelLocationAddRequestDto;
import hotel.uz.hotel.dto.request.HotelLocationUpdateRequestDto;
import hotel.uz.hotel.dto.response.HotelLocationResponseDto;
import hotel.uz.hotel.repository.HotelLocationRepository;
import hotel.uz.hotel.repository.HotelRepository;
import hotel.uz.hotel.service.HotelLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HotelLocationServiceImpl implements HotelLocationService {
    private final HotelLocationRepository hotelLocationRepository;
    private final HotelRepository hotelRepository;

    public HotelLocationServiceImpl(HotelLocationRepository hotelLocationRepository, HotelRepository hotelRepository) {
        this.hotelLocationRepository = hotelLocationRepository;
        this.hotelRepository = hotelRepository;
    }


    @Override
    public HotelLocationResponseDto add(HotelLocationAddRequestDto dto) {
        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel most not be id " + dto.getHotelId()));

        Address address = new Address();
        address.setCity(dto.getLocation().getCity());
        address.setStreetAddress(dto.getLocation().getStreetAddress());
        address.setState(dto.getLocation().getState());
        address.setZipCode(dto.getLocation().getZipCode());
        address.setCountry(dto.getLocation().getCountry());

        HotelLocation hotelLocation = new HotelLocation();

        hotelLocation.setLocation(address);
        hotelLocation.setHotel(hotel);
        hotelLocation.setName(dto.getName());
        hotelLocationRepository.save(hotelLocation);
        return HotelLocationResponseDto.builder()
                .id(hotelLocation.getId())
                .location(address)
                .name(hotelLocation.getName())
                .hotelName(hotel.getName())
                .build();
    }

    @Override
    public HotelLocationResponseDto update(HotelLocationUpdateRequestDto dto) {
        HotelLocation hotelLocation = hotelLocationRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be id " + dto.getId()));

        Hotel hotel = hotelRepository.findById(dto.getHotelId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel most not be id " + dto.getHotelId()));

        Address address = new Address();
        address.setCity(dto.getLocation().getCity());
        address.setStreetAddress(dto.getLocation().getStreetAddress());
        address.setState(dto.getLocation().getState());
        address.setZipCode(dto.getLocation().getZipCode());
        address.setCountry(dto.getLocation().getCountry());

        hotelLocation.setLocation(address);
        hotelLocation.setHotel(hotel);
        hotelLocation.setName(dto.getName());
        hotelLocationRepository.save(hotelLocation);
        return HotelLocationResponseDto.builder()
                .id(hotelLocation.getId())
                .location(address)
                .name(hotelLocation.getName())
                .hotelName(hotel.getName())
                .build();
    }

    @Override
    public HotelLocationResponseDto getName(String name) {
        HotelLocation hotelLocation = hotelLocationRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be name " + name));

        return HotelLocationResponseDto.builder()
                .id(hotelLocation.getId())
                .location(hotelLocation.getLocation())
                .name(hotelLocation.getName())
                .hotelName(hotelLocation.getHotel().getName())
                .build();
    }

    @Override
    public HotelLocationResponseDto getId(Long id) {
        HotelLocation hotelLocation = hotelLocationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be id " + id));

        return HotelLocationResponseDto.builder()
                .id(hotelLocation.getId())
                .location(hotelLocation.getLocation())
                .name(hotelLocation.getName())
                .hotelName(hotelLocation.getHotel().getName())
                .build();
    }

    @Override
    public void delete(Long id) {
        HotelLocation hotelLocation = hotelLocationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be id " + id));

        hotelLocationRepository.delete(hotelLocation);
    }


}
