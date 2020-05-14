package Resourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class ResourceserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceserverApplication.class, args);
	}
	
	@Autowired
	ProductRepo repo;
	@Autowired
	OrderRepo1 repo2;
	
	 @Bean
	CommandLineRunner dlr(ApplicationContext ctx) {
		return s -> {

			String beans[] = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beans.length);
			for (int i = 0; i < beans.length; i++) { System.out.println(beans[i]); }
	
			
			 repo.save(new Product(01,"NailPolish", "Cosmetics item", "Cosmetics",200)); 
			 repo.save(new Product(02,"PaediaSure", "Kids drink", "Baby and Health",500));
			 repo.save(new Product(03,"Tablet", "Pain releif", "Helath",500));
			 repo.save(new Product(9,"Perfume", "Beauty and Skin care", "Fragrance",600)); 
			 repo.save(new Product(10,"T shirt", "Cloths", "Sale",500));
			 repo.save(new Product(11,"Hair Styling tool", "Hair tool", "electrical",500));
			 
			
		};

	}

}
