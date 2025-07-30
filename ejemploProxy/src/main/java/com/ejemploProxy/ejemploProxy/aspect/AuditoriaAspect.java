package com.ejemploProxy.ejemploProxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditoriaAspect {

    @Around("execution(* com.ejemplo.proxy.service.BancoService.transferir(..))")
    public Object auditarTransferencia(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Long origenId = (Long) args[0];
        Long destinoId = (Long) args[1];
        Double monto = (Double) args[2];

        System.out.printf("🕵️‍♂️ [AUDITORÍA] Intento de transferencia de $%.2f desde #%d a #%d%n",
                monto, origenId, destinoId);

        Object result = joinPoint.proceed();

        System.out.printf("✅ [AUDITORÍA] Transferencia completada%n");
        return result;
    }
}
