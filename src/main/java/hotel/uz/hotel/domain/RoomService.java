package hotel.uz.hotel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "room_service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoomService extends RoomCharge{
    private boolean isChargeable;
    private Date requestTime;



}
