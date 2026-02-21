package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.HouseKeeper;
import hotel.uz.hotel.dto.response.HouseKeeperPageHibernateResponseDto;
import hotel.uz.hotel.enums.AccountType;
import hotel.uz.hotel.service.HouseKeeperService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseKeeperServiceImpl implements HouseKeeperService {
    @Autowired
    private EntityManager entityManager;


    @Override
    public HouseKeeperPageHibernateResponseDto<HouseKeeper> pageHibernate(int page, int size) {
        int firstResult = page*size;

        TypedQuery<HouseKeeper> query = entityManager.createQuery("select p from person p where p.accountType =: type",HouseKeeper.class);
        query.setParameter("type", AccountType.MEMBER);
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<HouseKeeper> content = query.getResultList();

        Query countQuery = entityManager.createQuery("select count(p) from person where p.accountType =: type");
        countQuery.setParameter("type",AccountType.MEMBER);

        long totalElements = (long) countQuery.getSingleResult();
        int totalPages = (int) Math.ceil((double) totalElements/size);

        return new HouseKeeperPageHibernateResponseDto<>(content,page,size,totalElements,totalPages);
    }
}
