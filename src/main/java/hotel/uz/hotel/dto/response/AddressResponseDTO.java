package hotel.uz.hotel.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDTO {
    private String city;
    private String street;
    private String zipCode;
}
