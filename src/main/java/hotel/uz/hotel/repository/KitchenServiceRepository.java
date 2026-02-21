package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.KitchenService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenServiceRepository extends JpaRepository<KitchenService,Long> {
}
