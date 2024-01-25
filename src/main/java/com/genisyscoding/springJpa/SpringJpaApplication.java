package com.genisyscoding.springJpa;

import com.genisyscoding.springJpa.models.Video;
import com.genisyscoding.springJpa.repository.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(VideoRepository videoRepository){
		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				Video video = new Video().builder()
						.name(faker.name().name())
						.length(faker.number().randomDigit())
						.build();

				videoRepository.save(video);
			}
		};
	}
}
