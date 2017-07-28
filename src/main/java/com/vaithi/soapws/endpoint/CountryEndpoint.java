package com.vaithi.soapws.endpoint;

import org.example.countries.Country;
import org.example.countries.Currency;
import org.example.countries.GetCountryRequest;
import org.example.countries.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vaithi.soapws.repository.CountryRepository;

@Endpoint
public class CountryEndpoint {
	
	//private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	private static final String NAMESPACE_URI = "http://www.example.org/countries";
	

	private CountryRepository countryRepository;
	
	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}

	

}
