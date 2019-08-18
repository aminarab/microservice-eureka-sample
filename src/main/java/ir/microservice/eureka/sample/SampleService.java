package ir.microservice.eureka.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SampleService {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate cbRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/sample")
	public String sayHello() {
		return restTemplate.getForObject("http://my-client/hello", String.class);
	}

	@RequestMapping("/mytest")
	public String mytest() {
		return "hello";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SampleService.class, args);
	}

}
