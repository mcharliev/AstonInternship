package ru.consultingt1.charcountanalyzer.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Аспект для логирования методов и классов, аннотированных {@code @Loggable}.
 * При вызове таких методов в лог будут выводиться сообщения о начале выполнения метода,
 * его завершении и времени выполнения.
 */
@Aspect
@Component
@Slf4j
public class LoggableAspect {


}
