package hotel.uz.hotel.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HotelNamePageResponseDto<T>{
    private List<T> content;
    private int page;
    private int totalPages;
    private long totalElement;
    private int size;



}
