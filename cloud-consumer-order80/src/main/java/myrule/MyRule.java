package myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Rabbon自定义规则，不能放在@ComponentScan能扫描的包或者子包下面
//@SpringBootApplication里面包含@ComponentScan注解
@Configuration
public class MyRule {
    @Bean
    public IRule myRule(){
        return new RandomRule(); //随机
    }
}
