package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountAddRequestDto {
    private String id;
    private String password;
    private Long personId;

}
