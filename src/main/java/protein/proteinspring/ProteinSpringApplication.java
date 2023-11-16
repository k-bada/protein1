package protein.proteinspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProteinSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProteinSpringApplication.class, args);
	}
}
