package hotel.uz.hotel.domain;

import hotel.uz.hotel.enums.RoomStatus;
import hotel.uz.hotel.enums.RoomStyle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "style")
    @Enumerated(EnumType.STRING)
    private RoomStyle style;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RoomStatus status;

    @Column(name = "booking_price")
    private double bookingPrice;

    @Column(name = "is_smoking")
    private boolean isSmoking;

    @ManyToOne
    @JoinColumn(name = "hotel_location_id")
    private HotelLocation hotelLocation;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomHouseKeeping> roomHouseKeeping = new ArrayList<>();

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomKey> roomKey;





}
