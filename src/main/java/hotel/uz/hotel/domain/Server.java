package hotel.uz.hotel.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Server extends Person{
    @OneToMany(mappedBy = "server",cascade = CascadeType.MERGE)
    private List<RoomCharge> roomCharges;

}
