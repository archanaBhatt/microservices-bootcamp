package PrimaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class currencyRestController {
	
	@Autowired
	CurrencyRepo repo;
	
	@RequestMapping(path = "/a1", method = RequestMethod.POST)
	public ResponseEntity<String> saveCurrency(@RequestBody Currency curr ) {
		
		try {
			repo.save(curr);
		return ResponseEntity.ok("Data Saved !"+ HttpStatus.OK);
		}
		catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.ok("Exception occured!"+ HttpStatus.BAD_REQUEST);	
		}
	}
	
	@RequestMapping(path = "/a2", method = RequestMethod.POST)
	public ResponseEntity<String> updateCurrency(@RequestBody Currency curr ) {
		
		try {
		repo.save(curr);
		return ResponseEntity.ok("Data updated !"+ HttpStatus.OK);
		}
		catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.ok("Exception occured!"+ HttpStatus.BAD_REQUEST);	
		}
	}
	
	@RequestMapping(path = "/a3", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCurrency(@RequestBody Currency curr ) {
		
		try {
		repo.deleteById(curr.getId());
		return ResponseEntity.ok("Data Deleted!"+ HttpStatus.OK);
		}
		catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.ok("Exception occured!"+ HttpStatus.BAD_REQUEST);	
		}
	}
	
	@RequestMapping(path = "/a4", method = RequestMethod.POST)
	public double geturrency(@RequestBody currencyRequest curr ) {
	
		System.out.println("curr"+curr.getCountryCode());
		System.out.println((repo.getOne(curr.getCountryCode())).getConvFactor());
		try {
		double amount=(repo.getOne(curr.getCountryCode())).getConvFactor();
		return amount;
		}
		catch(Exception e) {
		e.printStackTrace();
		return 0.0;	
		}
	}

}
