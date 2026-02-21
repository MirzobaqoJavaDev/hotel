package hotel.uz.hotel.dto.request;

import hotel.uz.hotel.enums.RoomStatus;
import hotel.uz.hotel.enums.RoomStyle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomUpdateRequestDto {
    private Long id;
    private String roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private Long hotelLocationId;
}
