package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.HouseKeeper;
import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.domain.Room;
import hotel.uz.hotel.domain.RoomHouseKeeping;
import hotel.uz.hotel.dto.request.RoomHouseKeepingAddRequestDto;
import hotel.uz.hotel.dto.request.RoomHouseKeepingUpdateRequestDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.RoomHouseKeepingResponseDto;
import hotel.uz.hotel.enums.AccountType;
import hotel.uz.hotel.repository.PersonRepository;
import hotel.uz.hotel.repository.RoomHouseKeepingRepository;
import hotel.uz.hotel.repository.RoomRepository;
import hotel.uz.hotel.service.RoomHouseKeepingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomHouseKeepingServiceImpl implements RoomHouseKeepingService {
    @Autowired
    private EntityManager entityManager;

    private final RoomHouseKeepingRepository roomHouseKeepingRepository;
    private final RoomRepository roomRepository;
    private final PersonRepository personRepository;

    public RoomHouseKeepingServiceImpl(RoomHouseKeepingRepository roomHouseKeepingRepository, RoomRepository roomRepository, PersonRepository personRepository) {
        this.roomHouseKeepingRepository = roomHouseKeepingRepository;
        this.roomRepository = roomRepository;
        this.personRepository = personRepository;
    }


    @Override
    public RoomHouseKeepingResponseDto create(RoomHouseKeepingAddRequestDto dto) {
        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found: " + dto.getRoomId()));

        Person person = personRepository.findById(dto.getHouseKeeperId())
                .orElseThrow(() -> new RuntimeException("Person not found: " + dto.getHouseKeeperId()));

        if (person.getAccountType() != AccountType.MEMBER) {
            throw new IllegalArgumentException("This people is not " + person.getName() + " member");
        }

        RoomHouseKeeping roomHouseKeeping = new RoomHouseKeeping();
        roomHouseKeeping.setDescription(dto.getDescription());
        roomHouseKeeping.setDuration(dto.getDuration());
        roomHouseKeeping.setStartDatetime(dto.getStartDateTime());
        roomHouseKeeping.setRoom(room);
        roomHouseKeeping.setHouseKeeper((HouseKeeper) person);

        roomHouseKeepingRepository.save(roomHouseKeeping);

        return RoomHouseKeepingResponseDto.builder()
                .id(roomHouseKeeping.getId())
                .description(roomHouseKeeping.getDescription())
                .startDatetime(roomHouseKeeping.getStartDatetime())
                .duration(roomHouseKeeping.getDuration())
                .roomId(room.getId())
                .houseKeeperId(person.getId())
                .build();
    }

    @Override
    public RoomHouseKeepingResponseDto update(RoomHouseKeepingUpdateRequestDto dto) {
        RoomHouseKeeping roomHouseKeeping = roomHouseKeepingRepository.findById(dto.getRoomHouseKeepingId())
                .orElseThrow(()-> new RuntimeException("Room house keeping not found: "+dto.getRoomHouseKeepingId()));

        roomHouseKeeping.setDescription(dto.getDescription());

        roomHouseKeepingRepository.save(roomHouseKeeping);

        return RoomHouseKeepingResponseDto.builder()
                .id(roomHouseKeeping.getId())
                .description(roomHouseKeeping.getDescription())
                .startDatetime(roomHouseKeeping.getStartDatetime())
                .duration(roomHouseKeeping.getDuration())
                .roomId(roomHouseKeeping.getRoom().getId())
                .houseKeeperId(roomHouseKeeping.getHouseKeeper().getId())
                .build();

    }

    @Override
    public RoomHouseKeepingPageHibernateResponseDto<RoomHouseKeeping> pageHibernate(int page, int size) {
        int firstResult =page*size;

        TypedQuery<RoomHouseKeeping> query = entityManager.createQuery("select r from roomHouseKeeping r",RoomHouseKeeping.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<RoomHouseKeeping> content = query.getResultList();

        Query countQuery = entityManager.createQuery("select count(r) from roomHouseKeeping r");

        long totalElements = (long) countQuery.getSingleResult();

        int totalPage = (int) Math.ceil((double) totalElements/size);

        return new  RoomHouseKeepingPageHibernateResponseDto<>(content,page,size,totalElements,totalPage);

    }

    @Override
    public void delete(Long id) {
        RoomHouseKeeping roomHouseKeeping = roomHouseKeepingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Room house keeping not found: "+id));

        roomHouseKeepingRepository.delete(roomHouseKeeping);

    }
}
