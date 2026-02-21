package hotel.uz.hotel.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MeasureExecutionTimeAspect {

    @Around("@annotation(MeasureExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(proceedingJoinPoint.getSignature()+"execution time is: -"+(start-end)+"ms");

        return result;
    }
}
