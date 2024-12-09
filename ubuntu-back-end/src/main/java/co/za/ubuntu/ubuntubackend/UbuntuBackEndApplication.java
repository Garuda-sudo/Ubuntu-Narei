package co.za.ubuntu.ubuntubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.za.ubuntu.ubuntubackend"})
public class UbuntuBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(UbuntuBackEndApplication.class, args);
    }

}
