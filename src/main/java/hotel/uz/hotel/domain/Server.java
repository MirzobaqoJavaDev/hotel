package hotel.uz.hotel.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Server extends Person{
    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Amenity> amenities = new ArrayList<>();

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomService> roomServices = new ArrayList<>();

    @OneToMany(mappedBy = "server", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<KitchenService> kitchenServices = new ArrayList<>();
}
