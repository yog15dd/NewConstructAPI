/**
 * 
 */
package com.microservices.controller.post.onboarding;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.entities.RequestModel.post.onboarding.PanDocumentDetail;
import com.microservices.entities.ResponseModel.post.onboarding.PanValidationResponse;
import com.microservices.utility.post.PostOnboardingDocumentValidationPanConstants;

/**
 * @author 33000005
 *
 */
@RestController
@RequestMapping("/api/v1/Post/Onboarding")
public class PostOnboaardingControllerWealth {

	/**
	 * 
	 */
	private RestTemplate restTemplate;
	
	//private Map<String, Object> map;
	
	@PostMapping("/Document/PanValidation")
	public PanValidationResponse getPanValidation(@Valid @RequestBody PanDocumentDetail panDetail, @RequestHeader String Token) {
		
//		map = new HashMap<String, Object>();
//		
//		String objpanDetail1Number = PostOnboardingDocumentValidationPanConstants.PostOnboardingDocumentValidationPanOR.getProperty("panDetail1Number");
//		map.put(objpanDetail1Number, panDetail.getDocNumber());
		
		HttpHeaders headers = new HttpHeaders();
		String objheaderToken = PostOnboardingDocumentValidationPanConstants.PostOnboardingDocumentValidationPanOR.getProperty("headerToken");
		headers.add(objheaderToken, Token);
		
//		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String,Object>>(map, headers);
		
		HttpEntity<PanDocumentDetail> entity = new HttpEntity<PanDocumentDetail>(panDetail, headers);
		
		restTemplate = new RestTemplate();
		
		String objPanValidationPostURL =  PostOnboardingDocumentValidationPanConstants.PostOnboardingDocumentValidationPanOR.getProperty("PanValidationPostURL");
	    return restTemplate.postForEntity(objPanValidationPostURL, entity, PanValidationResponse.class, headers).getBody();	
	}

}
