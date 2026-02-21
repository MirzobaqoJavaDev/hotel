package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.Account;
import hotel.uz.hotel.dto.request.AccountAddRequestDto;
import hotel.uz.hotel.dto.request.AccountPasswordUpdateRequestDto;
import hotel.uz.hotel.dto.request.AccountStatusUpdateRequestDto;
import hotel.uz.hotel.dto.response.AccountPageHibernateResponseDto;
import hotel.uz.hotel.dto.response.AccountResponseDto;
import hotel.uz.hotel.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountAddRequestDto dto){
        return ResponseEntity.ok(accountService.create(dto));
    }
    @PutMapping("/update/status")
    public ResponseEntity<AccountResponseDto> updateStatus(@RequestBody AccountStatusUpdateRequestDto dto){
        return ResponseEntity.ok(accountService.updateStatus(dto));
    }

    @PutMapping("/update/password")
    public ResponseEntity<AccountResponseDto> updatePassword(@RequestBody AccountPasswordUpdateRequestDto dto){
        return ResponseEntity.ok(accountService.resetPassword(dto));
    }

    @GetMapping("/page")
    public ResponseEntity<AccountPageHibernateResponseDto<Account>> page(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size){
        return ResponseEntity.ok(accountService.pageHibernate(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getId(@PathVariable String id){
        return ResponseEntity.ok(accountService.id(id));
    }




}
