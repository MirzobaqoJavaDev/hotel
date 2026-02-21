package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.Room;
import hotel.uz.hotel.enums.RoomStyle;

import java.util.Date;
import java.util.List;

public interface Search {
    List<Room> searchRoom(RoomStyle roomStyle, Date startDate,int duration);
}
