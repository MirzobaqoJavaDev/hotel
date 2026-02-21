package hotel.uz.hotel.dto.request;

import hotel.uz.hotel.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonEmployeeAddRequestDto {
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
