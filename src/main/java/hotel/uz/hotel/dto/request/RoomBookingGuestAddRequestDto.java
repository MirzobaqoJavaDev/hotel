package hotel.uz.hotel.dto.request;

import hotel.uz.hotel.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RoomBookingGuestAddRequestDto {
    private LocalDateTime startDate;
    private int durationInDays;
    private BookingStatus status;
    private String roomNumber;
    private String  email;


}
