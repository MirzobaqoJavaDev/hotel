package hotel.uz.hotel.domain;

import hotel.uz.hotel.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "bill_transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class BillTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createDate;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
