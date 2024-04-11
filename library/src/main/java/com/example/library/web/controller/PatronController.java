package com.example.library.web.controller;

import com.example.library.dtos.PatronDto;
import com.example.library.service.PatronService;
import com.example.library.web.response.ResponseModel;
import com.example.library.web.validation.PatronValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronController {

    @Autowired
    PatronService patronService;

    @Autowired
    private PatronValidator patronValidator;

    @InitBinder({"patronDto"})
    public void saveAndUpdateInitValidators(WebDataBinder binder) {
        binder.addValidators(patronValidator);
    }

    @PostMapping
    ResponseEntity<ResponseModel<Boolean>> savePatron(@Valid @RequestBody PatronDto patronDto) {
        Boolean isPatronSaved = patronService.savePatron(patronDto);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isPatronSaved).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }

    @GetMapping
    ResponseEntity<ResponseModel<List<PatronDto>>> findPatronList() {
        List<PatronDto> PatronDtoList = patronService.findPatronList();
        ResponseModel<List<PatronDto>> responseModel = ResponseModel.<List<PatronDto>>builder()
                .status(HttpStatus.OK.value()).data(PatronDtoList).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }
    @GetMapping("/{id}")
    ResponseEntity<ResponseModel<PatronDto>> findPatronById(@PathVariable Long id) {
        PatronDto PatronDto = patronService.findPatronById(id);
        ResponseModel<PatronDto> responseModel = ResponseModel.<PatronDto>builder()
                .status(HttpStatus.OK.value()).data(PatronDto).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseModel<Boolean>> deletePatronById(@PathVariable Long id) {
        Boolean isPatronDeleted = patronService.deletePatronById(id);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isPatronDeleted).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseModel<Boolean>> updatePatronById(@PathVariable Long id, @Valid @RequestBody PatronDto patronDto) {
        Boolean isPatronUpdated = patronService.updatePatronById(id, patronDto);
        ResponseModel<Boolean> responseModel = ResponseModel.<Boolean>builder()
                .status(HttpStatus.OK.value()).data(isPatronUpdated).build();
        return ResponseEntity.status(responseModel.getStatus()).body(responseModel);
    }
}
