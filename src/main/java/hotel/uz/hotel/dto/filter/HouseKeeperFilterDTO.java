package hotel.uz.hotel.dto.filter;

import hotel.uz.hotel.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseKeeperFilterDTO {
    private String name;
    private String email;
    private String phone;
    private AccountType accountType;
    private String city;
    private int page = 0;
    private int size = 10;
    private String sortBy = "id";
}
