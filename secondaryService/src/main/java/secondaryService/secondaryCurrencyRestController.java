package secondaryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;







@RestController
@RibbonClient(name = "PrimaryService")
public class secondaryCurrencyRestController {
//@Bean
//@LoadBalanced
//RestTemplate createRestTemplate() {
//return (new RestTemplateBuilder()).build();
//}

//@Autowired
//RestTemplate restTemplate;
RestTemplate restTemplate = new RestTemplate();

@Autowired
CurrencyService currencyService;

@Autowired
DiscoveryClient discoveryClient;

@Autowired
LoadBalancerClient lbClient;

@RequestMapping(path = "/v1/Restexample/{id}/{amount}")
public double  getConvertedAmount(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("id"+id+"amount"+amount);
		currencyRequest dRequest = createCurrencyRequest(id);
		System.out.println("dRequest"+dRequest);
		HttpEntity<currencyRequest> httpentity = new HttpEntity<currencyRequest>(dRequest);
		System.out.println("httpentity"+httpentity);
		ResponseEntity<currencyResponse> cResponse = restTemplate.exchange("http://192.168.99.102:8000/a4",
				HttpMethod.POST, httpentity, currencyResponse.class);
        System.out.println("cResponse"+cResponse);
        double conAmount=amount/(cResponse.getBody()).getConvertor();
		return conAmount;
      
}


@RequestMapping(path = "/v2/Restexample/{id}/{amount}")
public double  getConvertedInstances(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("id"+id+"amount"+amount);
		currencyRequest dRequest = createCurrencyRequest(id);
		System.out.println("dRequest"+dRequest);
		HttpEntity<currencyRequest> httpentity = new HttpEntity<currencyRequest>(dRequest);
		System.out.println("httpentity"+httpentity);
		List<ServiceInstance> instances = discoveryClient.getInstances("PrimaryService");
        System.out.println("Instances :" + instances);

		String uri = "http://" + (instances.get(0)).getHost() + ":" + (instances.get(0)).getPort() + "/a4";
		ResponseEntity<currencyResponse> cResponse = restTemplate.exchange(uri, HttpMethod.POST, httpentity,
					currencyResponse.class);
        System.out.println("cResponse"+cResponse);
        double conAmount=amount/(cResponse.getBody()).getConvertor();
		return conAmount;

}

@RequestMapping(path = "/v3/Restexample/{id}/{amount}")
public double  getConvertedloadBalancer(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("id"+id+"amount"+amount);
		currencyRequest dRequest = createCurrencyRequest(id);
		System.out.println("dRequest"+dRequest);
		HttpEntity<currencyRequest> httpentity = new HttpEntity<currencyRequest>(dRequest);
		ServiceInstance instance = lbClient.choose("PrimaryService");
        System.out.println("Lb Instance :" + instance);

		String uri = "http://" + instance.getHost() + ":" + instance.getPort() + "/a4";
		ResponseEntity<currencyResponse> cResponse = restTemplate.exchange(uri, HttpMethod.POST, httpentity,
					currencyResponse.class);
        System.out.println("cResponse"+cResponse);
        double conAmount=amount/(cResponse.getBody()).getConvertor();
		return conAmount;

}

@RequestMapping(path = "/v4/Restexample/{id}/{amount}")
public double  getloadBalancer(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("id"+id+"amount"+amount);
		currencyRequest dRequest = createCurrencyRequest(id);
		System.out.println("dRequest"+dRequest);
		HttpEntity<currencyRequest> httpentity = new HttpEntity<currencyRequest>(dRequest);
        System.out.println("I am Loadbalanced call");

		ResponseEntity<currencyResponse> cResponse = restTemplate.exchange("http://PrimaryService/a4", HttpMethod.POST, httpentity,
					currencyResponse.class);
        System.out.println("cResponse"+cResponse);
        double conAmount=amount/(cResponse.getBody()).getConvertor();
		return conAmount;

}

@RequestMapping(path = "/v5/Restexample/{id}/{amount}")
public double  gethystrix(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("Hystrix id"+id+"amount"+amount);
		currencyRequest cRequest = createCurrencyRequest(id);
		currencyResponse currRes= currencyService.calculateAmount(cRequest);
		System.out.println("Hystrix currRes"+currRes.getConvertor());
        double conAmount=amount/currRes.getConvertor();
		return conAmount;

}

@RequestMapping(path = "/v6/Restexample/{id}/{amount}")
public double  getfeign(@PathVariable Integer id,@PathVariable double amount) {
        System.out.println("Feign id"+id+"amount"+amount);
		currencyRequest cRequest = createCurrencyRequest(id);
		currencyResponse currRes= currencyService.calculateFeignAmount(cRequest);
		System.out.println("Feign currRes"+currRes.getConvertor());
        double conAmount=amount/currRes.getConvertor();
		return conAmount;

}

private currencyRequest createCurrencyRequest(Integer id) {
	currencyRequest currR= new currencyRequest();
	currR.setCountryCode(id);
	return currR;
}

}
