package hotel.uz.hotel.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomKeyUpdateActiveUserRequestDto {
    private String keyId;
    private boolean active;
}
