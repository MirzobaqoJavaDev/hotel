package hotel.uz.hotel.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class RoomKeyResponseDto {
    private String keyId;
    private String barcode;
    private boolean active;
    private boolean isMAster;
    private String roomNumber;

}
