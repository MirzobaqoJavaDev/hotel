package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Address;
import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonAddRequestDto;
import hotel.uz.hotel.dto.request.PersonUpdateRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;
import hotel.uz.hotel.enums.AccountType;
import hotel.uz.hotel.repository.PersonRepository;
import hotel.uz.hotel.repository.RoomRepository;
import hotel.uz.hotel.service.GuestService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {
    @Autowired
    private EntityManager entityManager;

   private final PersonRepository personRepository;

    public GuestServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponseDto createGuest(PersonAddRequestDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());
        person.setAccountType(AccountType.GUEST);

        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreetAddress(dto.getStreetAddress());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());

        person.setAddress(address);

        personRepository.save(person);

        return PersonResponseDto.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .accountType(person.getAccountType())
                .country(address.getCountry())
                .city(address.getCity())
                .streetAddress(address.getStreetAddress())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();

    }

    @Override
    public PersonResponseDto updateGuest(PersonUpdateRequestDto dto) {
        Person person = personRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new RuntimeException("Person not found: "+dto.getEmail()));

        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());
        person.setAccountType(AccountType.GUEST);

        Address address = new Address();
        address.setCountry(dto.getCountry());
        address.setCity(dto.getCity());
        address.setStreetAddress(dto.getStreetAddress());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());

        person.setAddress(address);

        personRepository.save(person);

        return PersonResponseDto.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .accountType(person.getAccountType())
                .country(address.getCountry())
                .city(address.getCity())
                .streetAddress(address.getStreetAddress())
                .state(address.getState())
                .zipCode(address.getZipCode())
                .build();

    }

    @Override
    public PersonPageResponseDto<Person> pageGuest(int page, int size) {
        int firstResult = page * size;

        TypedQuery<Person> query = entityManager.createQuery(
                "select p from person p where p.accountType= :type order by p.id", Person.class);
        query.setParameter("type", AccountType.GUEST);
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<Person> content = query.getResultList();

        Query countQuery = entityManager.createQuery("select count(p) from person p where p.accountType= :type ");
        countQuery.setParameter("type", AccountType.GUEST);

        long totalElements = (long) countQuery.getSingleResult();

        int totalPage = (int) Math.ceil((double) totalElements / size);

        return new PersonPageResponseDto<>(content, page, size, totalElements, totalPage);

    }

    @Override
    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Guest not found"));

        if (person.getAccountType().equals(AccountType.GUEST)){
            personRepository.delete(person);
        }else {
            throw new RuntimeException("This people not equals guest");
        }
    }

    @Override
    public void deleteGmail(String gmail) {
        Person person = personRepository.findByEmail(gmail)
                .orElseThrow(()-> new RuntimeException("Person not found: "+gmail));
        if (person.getAccountType().equals(AccountType.GUEST)){
            personRepository.delete(person);
        }else {
            throw new RuntimeException("This people not equals guest");
        }

    }
}
