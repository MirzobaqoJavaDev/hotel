package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.dto.filter.HouseKeeperFilterDTO;
import hotel.uz.hotel.dto.response.HouseKeeperResponseDto;
import hotel.uz.hotel.service.HouseKeeperService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseKeeperServiceImpl implements HouseKeeperService {
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<HouseKeeperResponseDto> filter(HouseKeeperFilterDTO filterDTO) {


    }
}
