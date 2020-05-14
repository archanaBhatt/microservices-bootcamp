package Login.Login;


import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;





@RestController
public class logincontroller {
	
	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(path = "/login/{username}/{password}")
	public String  getConvertedAmount(@PathVariable String username,@PathVariable String password) {
		
		if("Archana".equalsIgnoreCase(username) && "Bhatt".equalsIgnoreCase(password))
     {
	       
		String auth = "javainuse-client:javainuse-secret";
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.UTF_8));
		String authHeaderValue = "Basic " + new String(encodedAuth);
		System.out.println("authHeaderValue"+authHeaderValue);
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", authHeaderValue);
		
		HttpEntity<String> httpentity = new HttpEntity(headers);
		
		System.out.println("httpentity"+httpentity);
		
		String outhurl="http://localhost:9091/oauth/token";
		String granttype="client_credentials";
		
		String authTokenAccessUrl=outhurl+"?grant_type="+granttype;
		System.out.println("authTokenAccessUrl:::"+authTokenAccessUrl);
		
		ResponseEntity<String> cResponse =restTemplate.exchange(authTokenAccessUrl
				,HttpMethod.POST, httpentity, String.class);
		System.out.println("cResponse"+cResponse);
		return cResponse.getBody();
		
       }

   else
       {
	   return  "Please provide valid credentials!!!";
       }
		
	}

}
