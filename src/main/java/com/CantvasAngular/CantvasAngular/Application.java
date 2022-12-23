package com.CantvasAngular.CantvasAngular;

import com.CantvasAngular.CantvasAngular.Models.SiteUser;
import com.CantvasAngular.CantvasAngular.Repository.SiteUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(SiteUserRepository siteuserRepository) {
        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                SiteUser siteUser = new SiteUser(name, name.toLowerCase() + "@domain.com");
//                siteuserRepository.save(siteUser);
//            });
//            siteuserRepository.findAll().forEach(System.out::println);
        };
    }
}
