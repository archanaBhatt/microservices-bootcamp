package secondaryService;

public class currencyRequest {
	
	private double amount;
	private Integer countryCode;
	
	public currencyRequest(double amount, Integer countryCode) {
		super();
		this.amount = amount;
		this.countryCode = countryCode;
	}
	
	
	public currencyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	
	

}
