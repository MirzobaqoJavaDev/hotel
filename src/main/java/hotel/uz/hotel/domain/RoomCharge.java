package hotel.uz.hotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "room_charge")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class RoomCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime issuedAt;

    @OneToOne
    @JoinColumn(name = "invoice_item_id")
    private InvoiceItem invoiceItem;

    @ManyToOne
    @JoinColumn(name = "server_id")
    protected Server server;


}
