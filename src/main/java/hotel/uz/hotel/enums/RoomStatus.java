package hotel.uz.hotel.enums;

import lombok.Getter;

@Getter
public enum RoomStatus {
    AVAILABLE,
    RESERVED,
    OCCUPIED,
    NOT_AVAILABLE,
    BEING_SERVICED,
    OTHER
}
