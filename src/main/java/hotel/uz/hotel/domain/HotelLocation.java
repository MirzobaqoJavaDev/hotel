package hotel.uz.hotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel_location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Embedded
    private Address location;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(mappedBy = "hotelLocation",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    public List<Room> getRoom(){
        return rooms;
    }

}
