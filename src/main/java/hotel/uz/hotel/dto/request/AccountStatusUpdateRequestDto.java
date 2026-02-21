package hotel.uz.hotel.dto.request;

import hotel.uz.hotel.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountStatusUpdateRequestDto {
    private String id;
    private AccountStatus accountStatus;
}
