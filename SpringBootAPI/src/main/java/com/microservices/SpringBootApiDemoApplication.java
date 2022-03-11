package com.microservices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.utility.call.CallShoppingGeneralConstants;
import com.microservices.utility.post.PostOnboardingDocumentValidationPanConstants;
import com.microservices.utility.pre.PreOnboardingWealthConstants;

@SpringBootApplication
public class SpringBootApiDemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootApiDemoApplication.class, args);
		
		 FileInputStream onboardingFileStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com//microservices//properties//pre//PreOnboardingWealth.properties");
		 PreOnboardingWealthConstants.PreOnboardingWealthOR = new Properties();
	     PreOnboardingWealthConstants.PreOnboardingWealthOR.load(onboardingFileStream);  
		 
		 FileInputStream shoppingFileStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com//microservices//properties//call//CallShoppingGeneral.properties");
		 CallShoppingGeneralConstants.CallShoppingGeneralOR = new Properties();
		 CallShoppingGeneralConstants.CallShoppingGeneralOR.load(shoppingFileStream);
		 
		 FileInputStream postOnboardingDocValidationPanFileStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//com//microservices//properties//post//PostOnboardingDocumentValidationPAN.properties");
		 PostOnboardingDocumentValidationPanConstants.PostOnboardingDocumentValidationPanOR = new Properties();
		 PostOnboardingDocumentValidationPanConstants.PostOnboardingDocumentValidationPanOR.load(postOnboardingDocValidationPanFileStream);
				 
		 System.out.println(System.getProperty("user.dir"));
	}

}
