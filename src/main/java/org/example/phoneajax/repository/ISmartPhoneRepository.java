package org.example.phoneajax.repository;

import org.example.phoneajax.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone, Long> {
}
