package hotel.uz.hotel.controller;

import hotel.uz.hotel.domain.Person;
import hotel.uz.hotel.dto.request.PersonEmployeeAddRequestDto;
import hotel.uz.hotel.dto.response.PersonPageResponseDto;
import hotel.uz.hotel.dto.response.PersonResponseDto;
import hotel.uz.hotel.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create/employee")
    public ResponseEntity<PersonResponseDto> createEmployee(@RequestBody PersonEmployeeAddRequestDto dto){
        return ResponseEntity.ok(personService.createEmployee(dto));
    }


    @PutMapping("/update/employee")
    public ResponseEntity<PersonResponseDto> updateEmployee(@RequestBody PersonEmployeeAddRequestDto dto){
        return ResponseEntity.ok(personService.updateEmployee(dto));
    }

    @GetMapping("/employee/all")
    public ResponseEntity<PersonPageResponseDto<Person>> pageEmployee(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(personService.pageEmployee(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> id(@PathVariable Long id){
        return ResponseEntity.ok(personService.id(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }



}
