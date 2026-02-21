package hotel.uz.hotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "invoice_item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "room_booking_id")
    private RoomBooking roomBooking;

    @OneToOne(mappedBy = "invoiceItem",cascade = CascadeType.ALL)
    private RoomCharge roomCharge;


}
