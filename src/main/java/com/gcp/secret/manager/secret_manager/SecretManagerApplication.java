package com.gcp.secret.manager.secret_manager;

import com.google.cloud.spring.secretmanager.SecretManagerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecretManagerApplication implements ApplicationRunner {

	@Value("${sm://database-password}")
	private String dbPassword;

	@Value("${sm://projects/795119892706/secrets/database-password}")
	private String dbPasswordTwo;

	@Value("${gcp-pwd}")
	private String dbPasswordGcpPwd;

	@Autowired
	private SecretManagerTemplate secretManagerTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SecretManagerApplication.class, args);
	}

	@Override
	public void run(final ApplicationArguments args) throws Exception {
		System.out.println("started");
		System.out.println("dbPassword: " + dbPassword);
		System.out.println("dbPasswordTwo: " + dbPasswordTwo);
		System.out.println("dbPasswordGcpPwd: " + dbPasswordGcpPwd);
		System.out.println("dbPassword Template: " + secretManagerTemplate.getSecretString("database-password"));
	}
}
