package hotel.uz.hotel.domain;

import hotel.uz.hotel.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "room_booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String reservationNumber;
    private LocalDateTime startDate;
    private int durationInDays;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    @Column(updatable = false)
    private LocalDateTime createAt = LocalDateTime.now();



    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToOne(mappedBy = "roomBooking",cascade = CascadeType.ALL)
    private Invoice invoice;


    @OneToOne(mappedBy = "roomBooking",cascade = CascadeType.ALL)
    private InvoiceItem invoiceItem;

    @OneToMany(mappedBy = "roomBooking",cascade = CascadeType.ALL)
    private List<Notification> notification;

}
