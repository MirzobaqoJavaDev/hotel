package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomHouseKeepingUpdateRequestDto {
    private Long roomHouseKeepingId;
    private String description;
}
