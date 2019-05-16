package com.certiorem.librarymicroservicesproject.constants;

public class PurchasePathConstants {

	// URL path
	public static final String PURCHASE_SERVICE_SAVE = "/purchase/save";
	public static final String PURCHASE_SERVICE_READ = "/purchase/read";
	public static final String PURCHASE_SERVICE_DELETE = "/purchase/delete";
	public static final String PURCHASE_SERVICE_GET_ALL = "/purchase/all";
	public static final String PURCHASE_SERVICE_GET_BY_PROVIDER = "/purchase/by-provider";
	
	// URL Params names
	public static final String PURCHASE_SERVICE_ID_PARAM_NAME = "id";
	public static final String PURCHASE_SERVICE_PROVIDER_ID_PARAM_NAME = "providerId";
	
	// URL Params path
	public static final String PURCHASE_SERVICE_ID_PARAM = "?id={" + PURCHASE_SERVICE_ID_PARAM_NAME + "}";
	public static final String PURCHASE_SERVICE_PROVIDER_ID_PARAM = "?providerId={" + PURCHASE_SERVICE_PROVIDER_ID_PARAM_NAME + "}";
	
}
