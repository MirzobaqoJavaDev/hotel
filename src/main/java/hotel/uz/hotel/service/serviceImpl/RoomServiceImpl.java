package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.HotelLocation;
import hotel.uz.hotel.domain.Room;
import hotel.uz.hotel.dto.request.RoomAddRequestDto;
import hotel.uz.hotel.dto.request.RoomUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomResponseDto;
import hotel.uz.hotel.repository.HotelLocationRepository;
import hotel.uz.hotel.repository.RoomRepository;
import hotel.uz.hotel.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelLocationRepository hotelLocationRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HotelLocationRepository hotelLocationRepository) {
        this.roomRepository = roomRepository;
        this.hotelLocationRepository = hotelLocationRepository;
    }

    @Override
    public RoomResponseDto add(RoomAddRequestDto dto) {
        HotelLocation hotelLocation = hotelLocationRepository.findById(dto.getHotelLocationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be id " + dto.getHotelLocationId()));

        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setStyle(dto.getStyle());
        room.setStatus(dto.getStatus());
        room.setBookingPrice(dto.getBookingPrice());
        room.setSmoking(dto.isSmoking());

        room.setHotelLocation(hotelLocation);

        roomRepository.save(room);

        return RoomResponseDto.builder()
                .roomNumber(room.getRoomNumber())
                .style(room.getStyle())
                .status(room.getStatus())
                .bookingPrice(room.getBookingPrice())
                .isSmoking(room.isSmoking())
                .hotelLocationId(hotelLocation.getId())
                .build();
    }

    @Override
    public RoomResponseDto update(RoomUpdateRequestDto dto) {
        Room room = roomRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room most not be id " + dto.getId()));

        HotelLocation hotelLocation = hotelLocationRepository.findById(dto.getHotelLocationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel location most not be id " + dto.getHotelLocationId()));

        room.setRoomNumber(dto.getRoomNumber());
        room.setStyle(dto.getStyle());
        room.setStatus(dto.getStatus());
        room.setBookingPrice(dto.getBookingPrice());
        room.setSmoking(dto.isSmoking());

        room.setHotelLocation(hotelLocation);

        roomRepository.save(room);

        return RoomResponseDto.builder()
                .roomNumber(room.getRoomNumber())
                .style(room.getStyle())
                .status(room.getStatus())
                .bookingPrice(room.getBookingPrice())
                .isSmoking(room.isSmoking())
                .hotelLocationId(hotelLocation.getId())
                .build();

    }

    @Override
    public RoomResponseDto getName(String name) {
        Room room = roomRepository.findByRoomNumber(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room most not be name " + name));
        return RoomResponseDto.builder()
                .roomNumber(room.getRoomNumber())
                .style(room.getStyle())
                .status(room.getStatus())
                .bookingPrice(room.getBookingPrice())
                .isSmoking(room.isSmoking())
                .hotelLocationId(room.getHotelLocation().getId())
                .build();

    }

    @Override
    public RoomResponseDto getId(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room most not be id " + id));
        return RoomResponseDto.builder()
                .roomNumber(room.getRoomNumber())
                .style(room.getStyle())
                .status(room.getStatus())
                .bookingPrice(room.getBookingPrice())
                .isSmoking(room.isSmoking())
                .hotelLocationId(room.getHotelLocation().getId())
                .build();
    }

    @Override
    public void delete(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room most not be id " + id));

        roomRepository.delete(room);

    }
}
