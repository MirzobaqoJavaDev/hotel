package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseKeeperAssignUpdateRequestDto {
    private Long roomId;
    private Long houseKeeperId;
}
