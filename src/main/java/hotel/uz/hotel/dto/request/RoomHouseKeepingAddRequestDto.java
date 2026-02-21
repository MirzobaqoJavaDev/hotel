package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RoomHouseKeepingAddRequestDto {
    private Long roomId;
    private Long houseKeeperId;
    private String description;
    private LocalDateTime startDateTime;
    private int duration;

}
