package hellojava.conf;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnClass(Tomcat.class)
@ConditionalOnProperty(name = "log-v", matchIfMissing = true)
public class LogTomcatVersionAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(LogTomcatVersionAutoConfiguration.class);

    @PostConstruct
    public void log(){
        logger.info("\n\nTomcat version = " + Tomcat.class.getPackage().getImplementationVersion());
    }

}
