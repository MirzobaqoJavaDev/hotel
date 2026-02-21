package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseKeeperAssignRequestDto {
    private Long roomId;
    private Long houseKeeperId;
}
