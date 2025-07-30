package com.ejemploProxy.ejemploProxy.controller;

import com.ejemploProxy.ejemploProxy.service.BancoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransferenciaController {

    private final BancoService bancoService;

    public TransferenciaController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping("/transferir")
    public ResponseEntity<String> transferir(
            @RequestParam Long origen,
            @RequestParam Long destino,
            @RequestParam double monto) {
        bancoService.transferir(origen, destino, monto);
        return ResponseEntity.ok("Transferencia realizada");
    }
}
