package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class RoomKeyUpdateRequestDto {
    private String keyId;
    private String barcode;
    private Date issuedAt;
    private boolean active;
    private boolean isMAster;
    private Long roomId;

}
