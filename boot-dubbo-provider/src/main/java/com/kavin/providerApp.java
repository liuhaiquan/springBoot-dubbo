package com.kavin;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;


/**
 * 1、导入依赖；
 * 		1）、导入dubbo-starter
 * 		2）、导入dubbo的其他依赖
 * @author kavin
 *
 * SpringBoot与dubbo整合的三种方式：
 * 1）、导入dubbo-starter，在application.properties配置属性，
 *      使用@EnableDubbo【开启dubbo服务】使用@Service【暴露服务】使用@Reference【引用服务】
 * 2）、保留dubbo xml配置文件;
 * 		导入dubbo-starter，使用@ImportResource导入dubbo的配置文件.
 * 		使用spring注解把相应java类 注入到容器中（例如在UserServiceImpl类上加上@Service（spring的@Service）注解）
 * 3）、使用注解API的方式： 本项目中的MyDubboConfig.java
 * 		启动类开启@EnableDubbo 注解，使用@Service【暴露服务】使用@Reference【引用服务】
 * 		编写MyDubboConfig.java 配置类，将每一个组件手动创建到容器中,让dubbo来扫描其他的组件
 */

@EnableDubbo //开启基于注解的dubbo功能
//@ImportResource(locations="classpath:dubbo-provider.xml")

@EnableHystrix //开启Hystrix进行容错。 在方法上添加 @HystrixCommand(fallbackMethod = "isError") 进行异常回调。
@SpringBootApplication
public class providerApp {


    public static void main(String[] args) {
        SpringApplication.run(providerApp.class, args);

    }
}
