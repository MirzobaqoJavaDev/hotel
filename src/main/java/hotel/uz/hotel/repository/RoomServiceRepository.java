package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.RoomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService,Long> {
}
