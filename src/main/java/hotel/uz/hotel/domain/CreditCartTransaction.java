package hotel.uz.hotel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "credit_cart_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreditCartTransaction extends BillTransaction{
    private String nameOnCart;
    private String zipCode;

}
