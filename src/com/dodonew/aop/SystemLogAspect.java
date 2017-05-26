package com.dodonew.aop;

import com.dodonew.dao.SM_InterfaceLogMapper;
import com.dodonew.model.SM_InterfaceLog;
import com.dodonew.utils.ErrorEnum;
import com.dodonew.utils.ResultUtil;
import jvc.util.DateUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yukx on 17/4/12.
 */

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = Logger.getLogger(SystemLogAspect.class);

    @Autowired
    SM_InterfaceLogMapper sm_interfaceLogMapper;


    @Around("execution(public * com.dodonew.controller.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        logger.info("===============接口访问开始============");

        SM_InterfaceLog interfaceLog = new SM_InterfaceLog();
        interfaceLog.setLogTime(DateUtils.now("yyyy-MM-dd HH:mm:ss"));
        interfaceLog.setLogReturnStatus("1");

        long startTime = System.currentTimeMillis();
        String className = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        logger.info("请求方法:" + className + "." + method + "()");
        logger.info("参数:");
        Object[] args = joinPoint.getArgs();
        StringBuffer paramStr = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            String str = (joinPoint.getArgs()[i]).toString();
            paramStr.append(str);
            logger.info(str);
        }
        Object obj = null;
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            interfaceLog.setLogReturnStatus("0");
            int code = ErrorEnum.SYSTEM_ERROR.getCode();
            obj = ResultUtil.errorJson(code, ErrorEnum.getMsg(code));
        }

        long endTime = System.currentTimeMillis();
        long diffTime = endTime - startTime;

        // 记录访问日志
        interfaceLog.setClassName(className);
        interfaceLog.setMethodName(method);
        interfaceLog.setLogRequetParam(paramStr.toString());
        interfaceLog.setLogReturnData(obj.toString());
        interfaceLog.setTimeConsume(diffTime);

        try {
            sm_interfaceLogMapper.insert(interfaceLog);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("耗时:" + diffTime);
        logger.info("===============接口访问结束============");
        return obj;
    }

}
