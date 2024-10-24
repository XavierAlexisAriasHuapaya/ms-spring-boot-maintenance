package dev.arias.huapaya.ms_maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMaintenanceApplication.class, args);
	}

}
