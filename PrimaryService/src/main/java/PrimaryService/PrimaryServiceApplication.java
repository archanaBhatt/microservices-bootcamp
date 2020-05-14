package PrimaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PrimaryServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(PrimaryServiceApplication.class, args);
	}

	@Autowired
	CurrencyRepo repo;
	 @Bean
	CommandLineRunner dlr(ApplicationContext ctx) {
		return s -> {

			String beans[] = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beans.length);
			for (int i = 0; i < beans.length; i++) { System.out.println(beans[i]); }
	
			
			
			 repo.save(new Currency(01,12.3)); 
			 repo.save(new Currency(02,10.3));
			 repo.save(new Currency(03,9.7));
			 
			
		};

	}

}
