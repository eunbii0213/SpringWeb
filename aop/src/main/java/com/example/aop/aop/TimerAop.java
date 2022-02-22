package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {
    //특정 method의 실행시간을 logging.
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer(){}

    @Around("cut() && enableTimer()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch watch = new StopWatch();
        watch.start();
        Object result = joinPoint.proceed();

        watch.stop();

        System.out.println("total time:"+ watch.getTotalTimeSeconds());
    }
}
