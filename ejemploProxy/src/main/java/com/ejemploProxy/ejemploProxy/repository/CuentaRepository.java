package com.ejemploProxy.ejemploProxy.repository;

import com.ejemploProxy.ejemploProxy.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}

