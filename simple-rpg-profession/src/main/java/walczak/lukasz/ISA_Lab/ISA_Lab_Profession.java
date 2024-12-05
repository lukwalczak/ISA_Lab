package walczak.lukasz.ISA_Lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ISA_Lab_Profession {

	/**
	 * Application main entry point.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ISA_Lab_Profession.class, args);
	}

	/**
	 * @param baseUrl base URL
	 * @return configured endpoint for character module
	 */
	@Bean
	public RestTemplate restTemplate(@Value("http://localhost:8081") String baseUrl){
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}
}
