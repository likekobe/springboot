package com.how2java.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 如果你的其他包都在使用了@SpringBootApplication注解的main app所在的包及其下级包，
 * 则你什么都不用做，SpringBoot会自动帮你把其他包都扫描了。
 * 如果你有一些bean所在的包，不在main app的包及其下级包，那么你需要手动加上@ComponentScan注解并指定那个bean所在的包
 * 分布式项目需要用到@ComponentScan，因为它的包不会都在一个包下
 *
 * @MapperScan 会自动扫描这个包下的类，mapper上就不需要使用@Mapper注解了。
 * 但由于IDEA的问题，在@Autowired时会显示这个mapper红色，其实是能用的，加mapper上加@Repository注解就不会显示红色了
 */
@SpringBootApplication
//@ComponentScan("epoch")
@MapperScan("com.how2java.springboot.mapper")
public class SpringbootApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
