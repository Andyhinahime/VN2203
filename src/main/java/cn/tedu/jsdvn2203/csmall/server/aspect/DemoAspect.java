package cn.tedu.jsdvn2203.csmall.server.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 面向切面編成:
 * 1.@Component 編寫AOP配置的類必須保存在spring容器中才能使配置生效
 * 2.@Aspect 表示當前的類是一個編寫切面的類
 */

@Aspect
@Slf4j
public class DemoAspect {
    /**
     * 3.定義切面 - 指定方法
     */
    @Pointcut("execution(public * cn.tedu.jsdvn2203.csmall.server.controller.BrandController.list(..))")
    public void pointCut() {
        /**
         *定義註解後必須跟一個方法的聲明 -
         *這個方法單純的定義這個切面的名稱,不需要寫任何代碼
         */
    }

    /** 4.織入切面 */
    /** 4.1前置advice */
    @Before("pointCut()")
    public void before(){
      log.debug("前置advice執行......");
    }

    /** 4.2後置advice */
    @After("pointCut()")
    public void after(){
        log.debug("後置advice執行......");
    }

    /** 4.3異常advice - 發生異常時才會執行 */
    @AfterThrowing("pointCut()")
    public void throwing(){
        log.debug("方法發生異常,執行了異常advice......");
    }

    /**
     * 4.4環繞advice
     *   4.4.1 ProceedingJoinPoint 必須要此參數調用切面方法
     *         此方法必須要有返回值,調用切面的方法可能有返回值,環繞advice不返回這個值,
     *         調用者就接收不到這個值
     * */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        log.debug("環繞advice,目標方法運行之前...");

        Object object = joinPoint.proceed(); //調用目標的方法

        log.debug("環繞advice,目標方法運行之後...");

        return object;
    }

}









