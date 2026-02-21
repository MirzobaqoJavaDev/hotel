package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomKeyUpdateActiveMasterRequestDto {
    private String keyId;
    private boolean isMaster;
}
