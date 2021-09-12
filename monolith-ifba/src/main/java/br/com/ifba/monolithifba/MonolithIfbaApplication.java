package br.com.ifba.monolithifba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MonolithIfbaApplication {

	@GetMapping("/sistema-ifba")
	public String getIfbaService() {
		return "SISTEMA DO IFBA";
	}

	public static void main(String[] args) {
		SpringApplication.run(MonolithIfbaApplication.class, args);
	}

}
