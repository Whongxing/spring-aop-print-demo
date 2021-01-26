# spring-aop-print-demo
SpringAop知识点学习
## 重要的基本概念
 - Aspect (切面)
 
    - 大白话就是你要在方法上执行一些代码增强，而这些要只执行的内容就是切面
 - JoinPoint (切入点) 
 
    - Spring允许加入通知的地方，我们在实现的时候，可以通过JoinPoint.getSignature()来获取代理类和被代理类的信息。
 - PointCut (切点)    
 
    - 通过切点定位到某一个特定的连接点，比如我们要在那些方法上面进行通知
    
 # 直接上案例来说明
 #### 一、对于配置文件来说，我们需要如下配置
 
 ```
    <!-- 启用Spring对基于@AspectJ aspects的配置支持 -->
    <!-- 激活自动代理功能 -->
    <aop:aspectj-autoproxy  proxy-target-class="true"></aop:aspectj-autoproxy>
    <context:component-scan base-package="utilTest"/>
 ```
 #### 二、Maven项目的话引入AspectJ相关依赖
 ```
        <properties>
              <aspectj.version>1.6.11</aspectj.version>
        </properties>
       <!--使用AspectJ方式注解需要相应的包-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
        <!--使用AspectJ方式注解需要相应的包-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
 ```
 #### 三、建立一个Aspect切面类 
    对应代码中的java/utilTest/aspectJ/LogAspect.java
 #### 四、建立一个注解类
    对应代码中的java/utilTest/annotation/MyLog.java
    

#核心代码
```
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

```
    
