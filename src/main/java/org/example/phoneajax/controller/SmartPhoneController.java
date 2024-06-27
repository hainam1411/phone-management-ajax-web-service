package org.example.phoneajax.controller;

import org.example.phoneajax.model.SmartPhone;
import org.example.phoneajax.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("api/smartphones")
public class SmartPhoneController {
private final ISmartPhoneService smartPhoneService;
    @Autowired
    public SmartPhoneController(ISmartPhoneService smartPhoneService) {
        this.smartPhoneService = smartPhoneService;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> listSmartPhone(){
                  return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartphone(SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id){
        Optional<SmartPhone> smartPhoneOptional = smartPhoneService.findById(id);
        if(!smartPhoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            smartPhoneService.remove(id);
            return new ResponseEntity<>(smartPhoneOptional.get(), HttpStatus.NO_CONTENT);
    }

}
