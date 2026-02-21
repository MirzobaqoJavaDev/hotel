package hotel.uz.hotel.service.serviceImpl;

import hotel.uz.hotel.domain.Room;
import hotel.uz.hotel.domain.RoomKey;
import hotel.uz.hotel.dto.request.RoomKeyAddRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveMasterRequestDto;
import hotel.uz.hotel.dto.request.RoomKeyUpdateActiveUserRequestDto;
import hotel.uz.hotel.dto.response.RoomKeyPageResponseDto;
import hotel.uz.hotel.dto.response.RoomKeyResponseDto;
import hotel.uz.hotel.repository.RoomKeyRepository;
import hotel.uz.hotel.repository.RoomRepository;
import hotel.uz.hotel.service.RoomKeyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Query;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RoomKeyServiceImpl implements RoomKeyService {
    @Autowired
    private EntityManager entityManager;
    private final RoomKeyRepository roomKeyRepository;
    private final RoomRepository roomRepository;

    public RoomKeyServiceImpl(RoomKeyRepository roomKeyRepository, RoomRepository roomRepository) {
        this.roomKeyRepository = roomKeyRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomKeyResponseDto assignRoom(RoomKeyAddRequestDto dto) {

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(()-> new RuntimeException("Room not found"));

        RoomKey roomKey = new RoomKey();
        roomKey.setActive(false);
        roomKey.setBarcode(UUID.randomUUID().toString());
        roomKey.setMAster(dto.isMAster());
        roomKey.setIssuedAt(new Date());
        roomKey.setRoom(room);

        roomKeyRepository.save(roomKey);
        return RoomKeyResponseDto.builder()
                .keyId(roomKey.getKeyId())
                .active(roomKey.isActive())
                .barcode(roomKey.getBarcode())
                .isMAster(roomKey.isMAster())
                .build();
    }

    @Override
    public Boolean userActive(RoomKeyUpdateActiveUserRequestDto dto) throws BadRequestException {
        RoomKey roomKey = roomKeyRepository.findById(dto.getKeyId())
                .orElseThrow(()-> new EntityNotFoundException("Room key not found"));

        if (roomKey.isActive()==dto.isActive()){
            throw new BadRequestException("The key is already in this state");
        }

        roomKey.setActive(dto.isActive());
        roomKey.setIssuedAt(new Date());
        roomKeyRepository.save(roomKey);
        return true;
    }

    @Override
    public Boolean masterActive(RoomKeyUpdateActiveMasterRequestDto dto) throws BadRequestException {

        RoomKey roomKey = roomKeyRepository.findById(dto.getKeyId())
                .orElseThrow(()-> new EntityNotFoundException("Room key not found"));

        if (roomKey.isActive()==dto.isMaster()){
            throw new BadRequestException("The key is already in this state");
        }

        roomKey.setActive(dto.isMaster());
        roomKeyRepository.save(roomKey);
        return true;

    }

    @Override
    public RoomKeyPageResponseDto<RoomKey> pageHibernate(int page, int size) {
        int firstResult =page*size;

        Query query = entityManager.createQuery("select r from roomKey r order by r.keyId");
        query.setFirstResult(firstResult);
        query.setMaxResults(size);

        List<RoomKey> content = Collections.unmodifiableList(query.getResultList());

        Query countQuery = entityManager.createQuery("select count(r) from roomKey r");
        long totalElements = (long) countQuery.getSingleResult();

        int totalPage = (int) Math.ceil((double) totalElements/size);

        return new RoomKeyPageResponseDto<>(content,page,size,totalElements,totalPage);


//        return RoomKeyPageResponseDto.<RoomKey>builder()
//                .content(content)
//                .page(page)
//                .size(size)
//                .totalElements(totalElements)
//                .totalPages(totalPage)
//                .build();
    }

    @Override
    public Page<RoomKey> page(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return roomKeyRepository.findAll(pageable);
    }

    @Override
    public void delete(String keyId) {
        RoomKey roomKey = roomKeyRepository.findById(keyId)
                .orElseThrow(()-> new EntityNotFoundException("Room key not found"));
        roomKeyRepository.delete(roomKey);
    }


}
