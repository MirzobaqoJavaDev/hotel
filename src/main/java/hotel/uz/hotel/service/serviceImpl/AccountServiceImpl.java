package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Account;
import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.AccountAddRequestDto;
import hotel.uz.hotel.dto.request.AccountPasswordUpdateRequestDto;
import hotel.uz.hotel.dto.request.AccountStatusUpdateRequestDto;
import hotel.uz.hotel.dto.response.AccountPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.AccountResponseDto;
import hotel.uz.hotel.enums.AccountStatus;
import hotel.uz.hotel.repository.AccountRepository;
import hotel.uz.hotel.repository.PersonRepository;
import hotel.uz.hotel.service.AccountService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private EntityManager entityManager;
    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    public AccountServiceImpl(AccountRepository accountRepository, PersonRepository personRepository) {
        this.accountRepository = accountRepository;
        this.personRepository = personRepository;
    }

    @Override
    public AccountResponseDto create(AccountAddRequestDto dto) {
        Person person = personRepository.findById(dto.getPersonId())
                .orElseThrow(()-> new RuntimeException("Person not found: "+dto.getPersonId()));

        Account account = new Account();
        account.setId(person.getEmail());
        account.setPassword(dto.getPassword());
        account.setStatus(AccountStatus.ACTIVE);
        account.setPerson(person);

        accountRepository.save(account);
        return AccountResponseDto.builder()
                .id(account.getId())
                .password(account.getPassword())
                .personId(person.getId())
                .accountStatus(account.getStatus())
                .build();
    }

    @Override
    public AccountResponseDto updateStatus(AccountStatusUpdateRequestDto dto) {
        Account account = accountRepository.findById(dto.getId())
                .orElseThrow(()-> new RuntimeException("Account not found: "+dto.getId()));

        account.setStatus(dto.getAccountStatus());
        accountRepository.save(account);
        return AccountResponseDto.builder()
                .id(account.getId())
                .password(account.getPassword())
                .personId(account.getPerson().getId())
                .accountStatus(account.getStatus())
                .build();
    }

    @Override
    public AccountResponseDto resetPassword(AccountPasswordUpdateRequestDto dto) {
        Account account = accountRepository.findById(dto.getId())
                .orElseThrow(()-> new RuntimeException("Account not found: "+dto.getId()));

        account.setPassword(dto.getPassword());
        accountRepository.save(account);
        return AccountResponseDto.builder()
                .id(account.getId())
                .password(account.getPassword())
                .personId(account.getPerson().getId())
                .accountStatus(account.getStatus())
                .build();
    }

    @Override
    public AccountPageHibernateResponseDto<Account> pageHibernate(int page, int size) {
        int firstResult =page*size;

        TypedQuery<Account> query = entityManager.createQuery("select a from Account a",Account.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<Account> content = query.getResultList();

        Query countQuery = entityManager.createQuery("select count(a) from Account a");

        long totalElements = (long) countQuery.getSingleResult();

        int totalPage = (int) Math.ceil((double) totalElements/size);

        return AccountPageHibernateResponseDto.<Account>builder()
                .content(content)
                .page(page)
                .totalPages(totalPage)
                .size(size)
                .totalElements(totalElements)
                .build();

    }

    @Override
    public AccountResponseDto id(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account not found: "+id));
        return AccountResponseDto.builder()
                .id(account.getId())
                .password(account.getPassword())
                .personId(account.getPerson().getId())
                .accountStatus(account.getStatus())
                .build();

    }
}
