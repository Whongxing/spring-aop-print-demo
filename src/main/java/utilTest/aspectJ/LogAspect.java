package utilTest.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import utilTest.annotion.MyLog;

import java.lang.reflect.Method;

/**
 * 创建一个切面
 */
@Aspect
@Component("logAspect")
public class LogAspect {

    /**
     * Pointcut
     * 定义Pointcut，Pointcut名称为aspectjMethod,必须无参，无返回值
     * 只是一个标识，并不进行调用
     */
   // @Pointcut("execution(* utilTest.*.*(..))")
    @Pointcut("@annotation(utilTest.annotion.MyLog)")
    private void aspectJMethod(){};


    @Before("aspectJMethod()")
    public void a(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //获取注解类的属性
        MyLog log = method.getAnnotation(MyLog.class);
        if(log!=null){
            System.out.println(log.desc());
            System.out.println(log.name());
        }
    }

    @After("aspectJMethod()")
    public void b(){
        System.out.println("after");
    }
}
