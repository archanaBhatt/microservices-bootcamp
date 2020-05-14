package secondaryService;

import org.springframework.stereotype.Component;

@Component 
public class CurrencyServiceFallback implements Currencyserviceproxy {

	@Override
	public currencyResponse calculateCurrency(currencyRequest request) {
		return new currencyResponse(1.0);
		
	}

}
