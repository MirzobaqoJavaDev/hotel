package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Guest;
import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.domain.Room;
import hotel.uz.hotel.domain.RoomBooking;
import hotel.uz.hotel.dto.request.RoomBookingGuestAddRequestDto;
import hotel.uz.hotel.dto.request.RoomBookingReceptionistRequestDto;
import hotel.uz.hotel.dto.response.RoomBookingCheckInResponseDto;
import hotel.uz.hotel.dto.response.RoomBookingResponseDto;
import hotel.uz.hotel.enums.RoomStatus;
import hotel.uz.hotel.repository.PersonRepository;
import hotel.uz.hotel.repository.RoomBookingRepository;
import hotel.uz.hotel.repository.RoomRepository;
import hotel.uz.hotel.service.RoomBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RoomBookingServiceImpl implements RoomBookingService {


    private final PersonRepository personRepository;
    private final RoomBookingRepository roomBookingRepository;
    private final RoomRepository roomRepository;

    public RoomBookingServiceImpl(PersonRepository personRepository, RoomBookingRepository roomBookingRepository, RoomRepository roomRepository) {
        this.personRepository = personRepository;
        this.roomBookingRepository = roomBookingRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    @Override
    public RoomBookingResponseDto createGuest(RoomBookingGuestAddRequestDto dto) {
        Person person = personRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Person not found: " + dto.getEmail()));

        if (!(person instanceof Guest guest)){
            throw new RuntimeException("Person with email "+dto.getEmail()+" is not Guest");
        }

        guest.setTotalRoomsCheckedIn(guest.getTotalRoomsCheckedIn() + 1);

        RoomBooking roomBooking = new RoomBooking();

        Room room = roomRepository.findByRoomNumber(dto.getRoomNumber())
                .orElseThrow(() -> new RuntimeException("Room number not found: " + dto.getRoomNumber()));


        roomBooking.setStartDate(dto.getStartDate());
        roomBooking.setDurationInDays(dto.getDurationInDays());
        roomBooking.setStatus(dto.getStatus());
        roomBooking.setReservationNumber("UZB" + UUID.randomUUID().toString().replace("-","").substring(0, 8).toUpperCase());
        roomBooking.setCheckOut(dto.getStartDate().plusDays(dto.getDurationInDays()));
        roomBooking.setRoom(room);

        roomBooking.setPerson(guest);

        personRepository.save(guest);
        roomBookingRepository.save(roomBooking);
        return RoomBookingResponseDto.builder()
                .id(roomBooking.getId())
                .startDate(roomBooking.getStartDate())
                .durationInDays(roomBooking.getDurationInDays())
                .status(roomBooking.getStatus())
                .reservationNumber(roomBooking.getReservationNumber())
                .build();
    }

    @Override
    public RoomBookingCheckInResponseDto checkIn(RoomBookingReceptionistRequestDto dto) {
        RoomBooking roomBooking = roomBookingRepository.findByReservationNumber(dto.getReservationNumber())
                .orElseThrow(() -> new RuntimeException("Reservation number not found: " + dto.getReservationNumber()));

        Room room = roomRepository.findById(roomBooking.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(room);
        roomBooking.setCheckIn(LocalDateTime.now());

        roomBookingRepository.save(roomBooking);

        return RoomBookingCheckInResponseDto.builder()
                .id(roomBooking.getId())
                .durationInDays(roomBooking.getDurationInDays())
                .status(roomBooking.getStatus())
                .reservationNumber(roomBooking.getReservationNumber())
                .checkIn(roomBooking.getCheckIn())
                .roomNumber(room.getRoomNumber())
                .build();
    }

}
