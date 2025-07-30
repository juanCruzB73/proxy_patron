package com.ejemploProxy.ejemploProxy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titular;
    private double saldo;

    public Long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta(Long id, String titular, double saldo) {
        this.id = id;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Cuenta() {
    }
}

