package hotel.uz.hotel.dto.response;

import hotel.uz.hotel.enums.RoomStatus;
import hotel.uz.hotel.enums.RoomStyle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoomResponseDto {
    private Long id;
    private String roomNumber;
    private RoomStyle style;
    private RoomStatus status;
    private double bookingPrice;
    private boolean isSmoking;
    private Long hotelLocationId;
}
