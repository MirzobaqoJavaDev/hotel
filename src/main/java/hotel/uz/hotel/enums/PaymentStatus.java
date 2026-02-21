package hotel.uz.hotel.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    UNPAID,
    PENDING,
    COMPLETED,
    FAILED,
    DECLINE,
    CANCELLED,
    ABANDONED,
    SETTLING,
    SETTLED,
    REFUNDED
}
