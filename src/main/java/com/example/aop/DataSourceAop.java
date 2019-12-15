package com.example.aop;

import com.example.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.example.annotation.Master) " +
            "&& (execution(* com.example.service..*.select*(..)) " +
            "|| execution(* com.example.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.example.annotation.Master) " +
            "|| execution(* com.example.service..*.insert*(..)) " +
            "|| execution(* com.example.service..*.add*(..)) " +
            "|| execution(* com.example.service..*.update*(..)) " +
            "|| execution(* com.example.service..*.edit*(..)) " +
            "|| execution(* com.example.service..*.delete*(..)) " +
            "|| execution(* com.example.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {

        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {

        DBContextHolder.master();
    }

}
