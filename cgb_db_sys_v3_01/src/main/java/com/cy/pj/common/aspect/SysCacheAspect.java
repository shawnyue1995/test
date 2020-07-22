package com.cy.pj.common.aspect;

import com.cy.pj.common.cache.SimpleCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysCacheAspect {

    @Autowired
    private SimpleCache simpleCache;

    /**
     * 由annotation，切入点表达式。由这个注解描述的方法为切入点方法
     *
     * @return
     */
    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")
    public void doCachePointCut() {
    }

    //@Pointcut("execution(* com.cy.pj.sys.service..*.updateObject(com.cy.pj.sys.pojo.SysDept))")
    @Pointcut("@annotation(com.cy.pj.common.annotation.ClearCache)")
    public void doClearCachePointCut() {
    }

    ;

    @AfterReturning("doClearCachePointCut()")
    public void doAfterReturning() {//目标方法正常结束以后执行
        System.out.println("==clear cache==");
        simpleCache.ClearObject();
    }
    //	   @AfterReturning("doClearCachePointCut()")
//	   public Object doAroundClearCache(ProceedingJoinPoint jp)throws Throwable{
//		   Object result=jp.proceed();
//		   simpleCache.clearObject();
//		   return result;
//	   }

    @Around("doCachePointCut()")
    public Object doCachePointCut(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("Get data from cache");
        Object obj = simpleCache.getObject("deptCache");//这个key的名字先自己写个固定值
        if (obj != null) return obj;
        Object result = pj.proceed();
        System.out.println("Put data from cache");
        simpleCache.putObject("deptCache", result);
        return result;
    }
}
