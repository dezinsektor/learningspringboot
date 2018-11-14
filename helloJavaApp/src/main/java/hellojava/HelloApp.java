package hellojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan
public class HelloApp {

    @Component
    @ConfigurationProperties("ololo")
    class MyProperties{
        Integer a;
        String b;
        List<Integer> c;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public List<Integer> getC() {
            return c;
        }

        public void setC(List<Integer> c) {
            this.c = c;
        }
    }

    @Autowired
    public void setMyProperties(MyProperties properties){
        System.out.println("Set my properties: " + properties.getA() +
                " " + properties.getB() +
                " " + properties.getC().stream().map(String::valueOf).reduce((s, s2) -> s+" "+s2).get());
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApp.class, args);
    }

}
