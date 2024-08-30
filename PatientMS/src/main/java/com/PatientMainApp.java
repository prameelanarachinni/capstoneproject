package com;
    import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

	@SpringBootApplication
	@EnableDiscoveryClient
	

	public class PatientMainApp {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			SpringApplication.run(PatientMainApp.class, args);
			

		}
		@Bean	
		@LoadBalanced
		RestTemplate restTemplate() {
			return new RestTemplate();
		}

	}



