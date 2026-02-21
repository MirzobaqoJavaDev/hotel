package hotel.uz.hotel.dto.response;

import hotel.uz.hotel.domain.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HotelLocationResponseDto {
    private Long id;
    private String name;
    private Address location;
    private String hotelName;
}
