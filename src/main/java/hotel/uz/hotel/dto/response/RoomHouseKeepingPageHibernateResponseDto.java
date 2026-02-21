package hotel.uz.hotel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomHouseKeepingPageHibernateResponseDto<T> {
    private List<T> connect;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
