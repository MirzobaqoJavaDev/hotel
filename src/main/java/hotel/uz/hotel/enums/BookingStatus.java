package hotel.uz.hotel.enums;

import lombok.Getter;

@Getter
public enum BookingStatus {
    REQUESTED,
    PENDING,
    CONFIRMED,
    CHECKED_IN,
    CHECKED_OUT,
    CANCELED,
    ABANDONED

}
