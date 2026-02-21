package hotel.uz.hotel.service;

import hotel.uz.hotel.domain.Account;
import hotel.uz.hotel.dto.request.AccountAddRequestDto;
import hotel.uz.hotel.dto.request.AccountPasswordUpdateRequestDto;
import hotel.uz.hotel.dto.request.AccountStatusUpdateRequestDto;
import hotel.uz.hotel.dto.response.AccountPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.AccountResponseDto;

public interface AccountService {
    AccountResponseDto create(AccountAddRequestDto dto);

    AccountResponseDto updateStatus(AccountStatusUpdateRequestDto dto);

    AccountResponseDto resetPassword(AccountPasswordUpdateRequestDto dto);

    AccountPageHibernateResponseDto<Account> pageHibernate(int page, int size);

    AccountResponseDto id(String  id);
}
