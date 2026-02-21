package hotel.uz.hotel.dto.response;

import hotel.uz.hotel.enums.BookingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
public class RoomBookingCheckInResponseDto {
    private Long id;
    private int durationInDays;
    private BookingStatus status;
    private String reservationNumber;
    private LocalDateTime checkIn;
    private String roomNumber;

}
