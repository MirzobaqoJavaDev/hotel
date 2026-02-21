package hotel.uz.hotel.dto.request;

import hotel.uz.hotel.domain.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelLocationAddRequestDto {
    private String name;
    private Address location;
    private Long hotelId;
}
