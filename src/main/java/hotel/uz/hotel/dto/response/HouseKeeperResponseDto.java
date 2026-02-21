package hotel.uz.hotel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HouseKeeperResponseDto {
    private Long roomId;
    private Long houseKeeperId;
}
