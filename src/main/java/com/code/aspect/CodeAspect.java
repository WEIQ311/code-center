package com.code.aspect;


import com.alibaba.fastjson.JSON;
import com.code.utils.GlobalUtils;
import com.code.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * AOP处理
 *
 * @author weiQiang
 */
@Slf4j
@Aspect
@Component
public class CodeAspect {

    /**
     * 开始时间,用于记录请求耗时
     */
    private static ThreadLocal<Long> beginTime = new ThreadLocal<>();
    /**
     * 请求Url
     */
    private static ThreadLocal<String> requestUrl = new ThreadLocal<>();

    /**
     * 请求之后拦截
     */
    @After("doController()")
    public void doAfter() {

    }

    /**
     * 返回时拦截
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "doController()")
    public void doAfterReturning(Object object) {
        long totalTime = System.currentTimeMillis() - beginTime.get();
        if (null != object) {
            if (object instanceof ResultEntity) {
                ((ResultEntity) object).setTotalTime(totalTime);
                if (null != ((ResultEntity) object).getData() && (((ResultEntity) object).getData() instanceof ArrayList)) {
                    ((ResultEntity) object).setTotal((long) ((ResultEntity) object).getData().size());
                }
                List<?> resultData = ((ResultEntity) object).getData();
                if (null != resultData && resultData.size() > 0) {
                    //空值字段不返回
                    ((ResultEntity) object).setData(JSON.parseArray(JSON.toJSONString(resultData)));
                }
            }
            log.debug("response:{}", object);
        } else {
            log.debug("response:{}", "无返回值");
        }
        log.info("请求:{},耗时:{}ms", requestUrl.get(), totalTime);
        beginTime.remove();
        requestUrl.remove();
    }

    /**
     * 请求之前拦截
     *
     * @param joinPoint
     */
    @Before("doController()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        beginTime.set(System.currentTimeMillis());
        requestUrl.set(request.getRequestURL().toString());
        log.info("url:{},方法:{},请求ip:{},类和方法:{}()", request.getRequestURL(), request.getMethod(), GlobalUtils.getIpAddress(request), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.code.controller.*.*(..))")
    public void doController() {
    }
}
