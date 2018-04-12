package com.nav.add.store;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.nav.add.domain.Partner;

public class CampaignMap {
	
	
private static Map<String,Partner> campaignMap=new HashMap<>();
	
	private CampaignMap(){
		
	}
	
	
	public static  synchronized Map<String, Partner> getCampaignMap(){
		return Collections.synchronizedMap(campaignMap);
	}


}
