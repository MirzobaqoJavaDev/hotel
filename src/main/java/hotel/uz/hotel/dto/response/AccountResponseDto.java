package hotel.uz.hotel.dto.response;

import hotel.uz.hotel.enums.AccountStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountResponseDto {
    private String id;
    private String password;
    private Long personId;
    private AccountStatus accountStatus;
}
