package hotel.uz.hotel.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "amenity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Amenity extends RoomCharge{
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;
    



}
