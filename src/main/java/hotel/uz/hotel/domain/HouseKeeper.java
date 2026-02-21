package hotel.uz.hotel.domain;

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
public class HouseKeeper extends Person{
    @OneToMany(mappedBy = "houseKeeper")
    private List<RoomHouseKeeping> roomHouseKeeping;
}
