package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.AmenityAddRequestDto;
import hotel.uz.hotel.dto.response.AmenityResponseDto;
import hotel.uz.hotel.enums.AccountType;
import hotel.uz.hotel.repository.*;
import hotel.uz.hotel.service.RoomChargeService;
import org.springframework.stereotype.Service;

@Service
public class RoomChargeServiceImpl implements RoomChargeService {
    private final RoomChargeRepository roomChargeRepository;
    private final AmenityRepository amenityRepository;
    private final RoomServiceRepository roomServiceRepository;
    private final KitchenServiceRepository kitchenServiceRepository;
    private final PersonRepository personRepository;


    public RoomChargeServiceImpl(RoomChargeRepository roomChargeRepository, AmenityRepository amenityRepository, RoomServiceRepository roomServiceRepository, KitchenServiceRepository kitchenServiceRepository, PersonRepository personRepository) {
        this.roomChargeRepository = roomChargeRepository;
        this.amenityRepository = amenityRepository;
        this.roomServiceRepository = roomServiceRepository;
        this.kitchenServiceRepository = kitchenServiceRepository;
        this.personRepository = personRepository;
    }

    @Override
    public AmenityResponseDto addAmenity(AmenityAddRequestDto dto) {
        Person person = personRepository.findById(dto.getServerId())
                .orElseThrow(()-> new RuntimeException("person not found: "+dto.getServerId()));

        if (person.getAccountType()!= AccountType.MEMBER){

        }
        return AmenityResponseDto.builder()

                .build();

    }
}
