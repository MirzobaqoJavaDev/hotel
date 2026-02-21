package hotel.uz.hotel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AmenityResponseDto {
    private Long id;
    private String name;
    private String description;
    private Long roomChargeId;


}
