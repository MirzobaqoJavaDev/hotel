package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.RoomCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomChargeRepository extends JpaRepository<RoomCharge,Long> {
}
