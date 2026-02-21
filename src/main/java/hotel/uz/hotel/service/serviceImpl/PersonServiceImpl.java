package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Address;
import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonEmployeeAddRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;
import hotel.uz.hotel.enums.AccountType;
import hotel.uz.hotel.repository.PersonRepository;
import hotel.uz.hotel.service.PersonService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Autowired
    private EntityManager entityManager;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PersonResponseDto createEmployee(PersonEmployeeAddRequestDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());
        person.setAccountType(dto.getAccountType());

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
    public PersonPageResponseDto<Person> pageEmployee(int page, int size) {

        int firstResult = page * size;

        TypedQuery<Person> query = entityManager.createQuery(
                "select p from person p where p.accountType!= :type order by p.id", Person.class);
        query.setParameter("type", AccountType.GUEST);
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<Person> content = query.getResultList();

        Query countQuery = entityManager.createQuery("select count(p) from person p where p.accountType!= :type ");
        countQuery.setParameter("type", AccountType.GUEST);

        long totalElements = (long) countQuery.getSingleResult();

        int totalPage = (int) Math.ceil((double) totalElements / size);

        return new PersonPageResponseDto<>(content, page, size, totalElements, totalPage);
    }

    @Override
    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Person not found: "+id));
        personRepository.delete(person);
    }

    @Override
    public PersonResponseDto id(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Person not found: "+id));
        return  PersonResponseDto.builder()
                .id(person.getId())
                .name(person.getName())
                .email(person.getEmail())
                .phone(person.getPhone())
                .accountType(person.getAccountType())
                .country(person.getAddress().getCountry())
                .city(person.getAddress().getCity())
                .streetAddress(person.getAddress().getStreetAddress())
                .state(person.getAddress().getState())
                .zipCode(person.getAddress().getZipCode())
                .build();
    }

    @Override
    public PersonResponseDto updateEmployee(PersonEmployeeAddRequestDto dto) {
        Person person = personRepository.findByEmail(dto.getEmail())
                .orElseThrow(()-> new RuntimeException("Person not found: "+dto.getEmail()));

        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setPhone(dto.getPhone());
        person.setAccountType(dto.getAccountType());

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
}
