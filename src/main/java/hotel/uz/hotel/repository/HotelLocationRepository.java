package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.HotelLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HotelLocationRepository extends JpaRepository<HotelLocation,Long> {

    Optional<HotelLocation> findByName(String name);
}
