package org.example.phoneajax.service;

import org.example.phoneajax.model.SmartPhone;
import org.example.phoneajax.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartPhoneService implements ISmartPhoneService{

    private final ISmartPhoneRepository smartPhoneRepository;
    @Autowired
    public SmartPhoneService(ISmartPhoneRepository smartPhoneRepository) {
        this.smartPhoneRepository = smartPhoneRepository;
    }

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
