package Resourceserver;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class OrderController  {
	
	@Autowired
	ProductRepo repop;
	@Autowired
	OrderRepo1 repo;

   
	@RequestMapping(path="/order/{itemids}", method=RequestMethod.GET)
	public String order(@PathVariable List<Integer> itemids,@RequestHeader("Authorization") String authorization) {
		System.out.println(authorization);
		System.out.println("Order Receive Controller");
		double totalPrice=0.0;
		for(int i=0;i<itemids.size();i++)
		{
	        Product pro=repop.getOne(itemids.get(i));
			System.out.println("id: " + pro);
	        double amount=pro.getMrp();
	        System.out.println("mrp: " + amount);
	        totalPrice=totalPrice+amount;
	        
	     }
		
		
		System.out.println("authorization"+authorization.substring(7));
		System.out.println("totalPrice"+totalPrice);
		System.out.println("repo"+repo);
		//repo.save(new Order1(uuid1.variant(),authorization,totalPrice));
		repo.save(new Order1(authorization.substring(7),totalPrice)); 
		System.out.println("Order Receive Controller"+totalPrice);
		String price =String.valueOf(totalPrice);
		return "Order Received :Total Amount--"+price;
	
}

}
