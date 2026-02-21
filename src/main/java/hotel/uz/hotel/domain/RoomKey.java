package hotel.uz.hotel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "room_key")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String keyId;
    private String barcode;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date issuedAt;

    private boolean active;
    private boolean isMAster;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;




}
