package hotel.uz.hotel.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonAddRequestDto {
    private String name;
    private String email;
    private String phone;

    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;


}
