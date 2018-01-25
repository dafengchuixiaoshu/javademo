package com.qiuan.framework.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by qiuan on 2017/11/20.
 */
@Configuration
@ComponentScan(basePackages = {"com.qiuan.framework.core"})
//@Import()
//@ImportResource
//@EnableAspectJAutoProxy
public class CoreConfig {
    /**
     @Configuration把一个类作为一个IoC容器，它的某个方法头上如果注册了@Bean，就会作为这个Spring容器中的Bean。

     @Lazy(true) 表示延迟初始化
     @DependsOn：定义Bean初始化及销毁时的顺序
     @Primary：自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常

     @Service用于标注业务层组件、
     @Controller用于标注控制层组件（如struts中的action）
     @Repository用于标注数据访问组件，即DAO组件。
     @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

     @Scope用于指定scope作用域的（用在类上）

     @Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用。如下：
     @Autowired @Qualifier("personDaoBean") 存在多个实例配合使用
     @Resource默认按名称装配，当找不到与名称匹配的bean才会按类型装配。

     @PostConstruct用于指定初始化方法（用在方法上）
     @PreDestory用于指定销毁方法（用在方法上）
     @Async异步方法调用
     */
}
