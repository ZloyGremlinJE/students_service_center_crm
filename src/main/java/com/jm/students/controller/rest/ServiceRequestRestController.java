package com.jm.students.controller.rest;

import com.jm.students.enums.StatusRequestType;
import com.jm.students.service.ServiceRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Рест контроллер для управления заявками
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/serviceRequest")
public class ServiceRequestRestController {

    private final ServiceRequestService serviceRequestService;

    /**
     * Метод обновления статуса заявки
     * принимает обновленный статус заявки
     * @param id идентификатор заявки
     * @return ResponseEntity возвращает статус ответа и статус заявки
     */
    @PutMapping("/updateStatusRequest/{id}")
    public ResponseEntity<StatusRequestType> updateStatusRequestType(@PathVariable Long id,
                                                                     @RequestBody StatusRequestType statusRequestType) {
        try {
            serviceRequestService.updateStatusRequestType(id, statusRequestType);
            return new ResponseEntity<>(statusRequestType, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
