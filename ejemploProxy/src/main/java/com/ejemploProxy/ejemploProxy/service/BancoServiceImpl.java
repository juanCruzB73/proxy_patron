package com.ejemploProxy.ejemploProxy.service;

import com.ejemploProxy.ejemploProxy.exception.SaldoInsuficienteException;
import com.ejemploProxy.ejemploProxy.model.Cuenta;
import com.ejemploProxy.ejemploProxy.repository.CuentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BancoServiceImpl implements BancoService {

    private final CuentaRepository cuentaRepo;

    public BancoServiceImpl(CuentaRepository cuentaRepo) {
        this.cuentaRepo = cuentaRepo;
    }

    @Override
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public void transferir(Long origenId, Long destinoId, double monto) {
        Cuenta origen = cuentaRepo.findById(origenId).orElseThrow();
        Cuenta destino = cuentaRepo.findById(destinoId).orElseThrow();

        if (origen.getSaldo() < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);

        cuentaRepo.save(origen);
        cuentaRepo.save(destino);
    }
}

