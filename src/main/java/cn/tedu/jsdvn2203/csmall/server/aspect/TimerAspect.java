package cn.tedu.jsdvn2203.csmall.server.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 統計Service方法的執行耗時的時間
 */
@Slf4j
@Component
@Aspect
public class TimerAspect {
    @Pointcut("execution(* cn.tedu.jsdvn2203.csmall.server.service.impl.*.*(..))")
    public void pointCut() {

    }

    @Around("execution(* cn.tedu.jsdvn2203.csmall.server.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        log.debug("環繞advice,目標方法運行之前...");
        long start = System.currentTimeMillis();

        Object timeAspect = joinPoint.proceed();

        log.debug("環繞advice,目標方法運行之後...");
        long end = System.currentTimeMillis();
        log.debug("當前匹配的組件類:{}",joinPoint.getTarget());
        log.debug("當前匹配的組件類的方法:{}",joinPoint.getSignature());
        log.debug("當前匹配的組件類的方法的參數列表:{}",joinPoint.getArgs());

        log.debug("共耗時:{}毫秒", (end - start));
        return timeAspect;
    }

}
