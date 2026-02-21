package hotel.uz.hotel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RoomHouseKeepingResponseDto {
    private Long id;
    private String description;
    private LocalDateTime startDatetime;
    private int duration;
    private Long roomId;
    private Long houseKeeperId;

}
