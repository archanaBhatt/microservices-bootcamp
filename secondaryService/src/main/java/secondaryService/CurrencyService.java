package secondaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class CurrencyService {
	
	@Bean
	@LoadBalanced
	RestTemplate createRestTemplate() {
		return (new RestTemplateBuilder()).build();
	}

	@Autowired
	RestTemplate restTemplate;
 
	@Autowired
	Currencyserviceproxy dProxy;


	@HystrixCommand(commandKey = "PrimaryService", fallbackMethod = "PrimaryServicefallback")
	public currencyResponse calculateAmount(currencyRequest cRequest) {

		HttpEntity<currencyRequest> httpentity = new HttpEntity<currencyRequest>(cRequest);
		ResponseEntity<currencyResponse> dResponse = restTemplate.exchange("http://PrimaryService/a4", HttpMethod.POST,
				httpentity, currencyResponse.class);
		System.out.println("Hystrix currRes"+dResponse.getBody());
		return dResponse.getBody();

	}

	public currencyResponse calculateFeignAmount(currencyRequest dRequest) {

		return dProxy.calculateCurrency(dRequest);
		

	}

	public currencyResponse PrimaryServicefallback(currencyRequest request) {
		System.out.println("I am fallback");
		return new currencyResponse(1.0);
	}

}
