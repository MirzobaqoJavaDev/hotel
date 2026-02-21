package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoomKeyAddRequestDto {
    private String keyId;
    private boolean isMAster;
    private Long roomId;

}
