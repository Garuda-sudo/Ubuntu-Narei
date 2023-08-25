package co.za.ubuntu.ubuntubackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogbookConfiguration {

    @Bean
    public org.zalando.logbook.Logbook logbook() {
        return org.zalando.logbook.Logbook.create();
    }
}
