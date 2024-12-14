package cz.crypto.portfolio;

import cz.crypto.portfolio.controller.CryptoController;
import cz.crypto.portfolio.model.Crypto;
import cz.crypto.portfolio.service.CryptoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

}
