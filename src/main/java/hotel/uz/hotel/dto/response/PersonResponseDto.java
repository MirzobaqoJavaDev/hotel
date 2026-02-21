package hotel.uz.hotel.dto.response;

import hotel.uz.hotel.enums.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private AccountType accountType;

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
