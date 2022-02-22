package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAOP {
    //실행 순서 >> before >> cut >> afterReturning
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){}
    /*지금 확인할 것은 들어가기전 argument(method 실행 전 어떤 값이 들어가는지?),
     들어가고나서는 어떤 값이 return이 되는지
    */
    @Before("cut()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        Object[] args = joinPoint.getArgs();
        //매개변수의 배열임


        for(Object obj : args){
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
            System.out.println("method : "+ method.getName());
        }
    }

    @AfterReturning(value = "cut()",returning = "obj") //joinpoint는 들어가는지점에 관한 정보를 가지고 있는 객체
    public void afterReturning(JoinPoint joinPoint, Object obj){
        //afterReturning은 오브젝트를 받을 수 있다.
        System.out.println("return obj");
        System.out.println(obj);
    }

}
