package hotel.uz.hotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;

    @OneToMany(mappedBy = "invoice",cascade = CascadeType.ALL)
    private List<InvoiceItem> invoiceItem = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "room_booking_id")
    private RoomBooking roomBooking;

}
