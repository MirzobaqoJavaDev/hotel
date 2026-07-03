package hotel.uz.hotel.specification;

import hotel.uz.hotel.domain.HouseKeeper;
import hotel.uz.hotel.dto.filter.HouseKeeperFilterDTO;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class HouseKeeperSpecification implements Specification<HouseKeeper> {
    private final HouseKeeperFilterDTO filter;
    @Override
    public Predicate toPredicate(Root<HouseKeeper> root, CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (filter.getName()!=null)
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                    "%"+filter.getName().toLowerCase()+"%"));
        if (filter.getEmail()!=null)
            predicates.add(criteriaBuilder.like(root.get("email"),"%"+filter.getEmail()+"%"));
        if (filter.getPhone()!=null)
            predicates.add(criteriaBuilder.equal(root.get("phone"),filter.getPhone()));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
