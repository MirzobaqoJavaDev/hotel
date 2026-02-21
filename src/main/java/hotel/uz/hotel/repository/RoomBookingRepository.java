package hotel.uz.hotel.repository;

import hotel.uz.hotel.domain.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBooking,Long> {
    Optional<RoomBooking> findByReservationNumber(String reservationNumber);
}
