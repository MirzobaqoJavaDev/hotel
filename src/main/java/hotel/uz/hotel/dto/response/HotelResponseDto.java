package hotel.uz.hotel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HotelResponseDto {
    private Long id;
    private String name;

}
