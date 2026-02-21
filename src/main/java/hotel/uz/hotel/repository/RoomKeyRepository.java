package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.RoomKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomKeyRepository extends JpaRepository<RoomKey,String> {
}
