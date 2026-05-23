package ma.formations;

import ma.formations.dtos.CustomerDto;
import ma.formations.service.IService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

@Bean
    public CommandLineRunner initDatabase(IService service) {
        return args -> {
            service.save(CustomerDto.builder().name("Name_1").serviceRendered("Service_1").address("Adress_1").build());
            service.save(CustomerDto.builder().name("Name_2").serviceRendered("Service_2").address("Adress_2").build());
            service.save(CustomerDto.builder().name("Name_3").serviceRendered("Service_3").address("Adress_3").build());
            service.save(CustomerDto.builder().name("Name_4").serviceRendered("Service_4").address("Adress_4").build());
        };
    }

}
