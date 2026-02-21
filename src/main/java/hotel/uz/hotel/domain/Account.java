package hotel.uz.hotel.domain;

import hotel.uz.hotel.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    private String id;
    @Getter(AccessLevel.NONE)
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public String getPassword() {
        return password;
    }
}
