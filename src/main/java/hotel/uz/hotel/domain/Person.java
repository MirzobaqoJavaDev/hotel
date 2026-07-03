package hotel.uz.hotel.domain;

import hotel.uz.hotel.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "phone",nullable = false)
    private String phone;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Embedded
    private Address address;

    @OneToOne(mappedBy ="person", cascade = CascadeType.ALL,orphanRemoval = true)
    private Account account;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<RoomBooking> roomBookings = new ArrayList<>();

}
