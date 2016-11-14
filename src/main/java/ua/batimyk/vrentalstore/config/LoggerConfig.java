package ua.batimyk.vrentalstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.batimyk.vrentalstore.SearchLogger;

/**
 * Created by N on 14-Nov-16.
 * video-rental-store-AWS
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class LoggerConfig {

    @Bean
    public SearchLogger searchLogger() {
        return new SearchLogger();
    }
}
