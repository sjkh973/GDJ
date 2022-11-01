package com.gdu.app05.service;

public class MovieServiceImpl implements MovieService {

	@Override
	public String getBoxOffice(String targetDt) {
		
		String key = "6f47c633ed30dcf44921a526b96a966d";
		
		String apiURL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		
		
		return null;
	}

}
