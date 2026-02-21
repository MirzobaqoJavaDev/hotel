package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AmenityAddRequestDto {
    private String name;
    private String description;
    private Long serverId;

}
