package com.certiorem.librarymicroservicesproject.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.certiorem.librarymicroservicesproject.constants.DatabasePathConstants;
import com.certiorem.librarymicroservicesproject.constants.PurchasePathConstants;
import com.certiorem.librarymicroservicesproject.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Object createUpdatePurchase(Object purchase) {
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(
				DatabasePathConstants.DATABASE_SERVICE_HOST + PurchasePathConstants.PURCHASE_SERVICE_SAVE, purchase, Object.class);
		return responseEntity.getBody();
	}

	@Override
	public Object getPurchase(Integer purchaseId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(PurchasePathConstants.PURCHASE_SERVICE_ID_PARAM_NAME, purchaseId);

		ResponseEntity<Object> responseEntity = restTemplate
				.getForEntity(DatabasePathConstants.DATABASE_SERVICE_HOST + PurchasePathConstants.PURCHASE_SERVICE_READ
						+ PurchasePathConstants.PURCHASE_SERVICE_ID_PARAM, Object.class, uriVariables);
		return responseEntity.getBody();
	}

	@Override
	public void deletePurchase(Integer purchaseId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(PurchasePathConstants.PURCHASE_SERVICE_ID_PARAM_NAME, purchaseId);

		restTemplate.delete(DatabasePathConstants.DATABASE_SERVICE_HOST + PurchasePathConstants.PURCHASE_SERVICE_DELETE
				+ PurchasePathConstants.PURCHASE_SERVICE_ID_PARAM, uriVariables);
	}

	@Override
	public List<Object> getAllPurchases() {
		ResponseEntity<List<Object>> response = restTemplate.exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + PurchasePathConstants.PURCHASE_SERVICE_GET_ALL, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Object>>() {
				});
		return response.getBody();
	}

	@Override
	public List<Object> getPurchasesByProviderId(Integer providerId) {
		Map<String, Integer> uriVariables = new HashMap<String, Integer>();
		uriVariables.put(PurchasePathConstants.PURCHASE_SERVICE_PROVIDER_ID_PARAM_NAME, providerId);
		ResponseEntity<List<Object>> response = restTemplate.exchange(
				DatabasePathConstants.DATABASE_SERVICE_HOST + PurchasePathConstants.PURCHASE_SERVICE_GET_BY_PROVIDER
						+ PurchasePathConstants.PURCHASE_SERVICE_PROVIDER_ID_PARAM,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Object>>() {
				}, uriVariables);
		return response.getBody();
	}

}
