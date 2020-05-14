package secondaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

//@Configuration
public class RibbonConfiguration {

	@Autowired
	@Lazy
	IClientConfig ribbonClientConfig;
	
	@Autowired
	@Lazy
	ILoadBalancer iLoadBalancer;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {

		return new RoundRobinRule();
		// return new AvailabilityFilteringRule();
	}

}