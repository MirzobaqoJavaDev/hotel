package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
    Optional<Hotel> findByName(String name);
    Page<Hotel> findByNameContainingIgnoreCase(String name, Pageable pageable);


}
