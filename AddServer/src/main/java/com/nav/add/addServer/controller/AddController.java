package com.nav.add.addServer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nav.add.domain.Partner;
import com.nav.add.exception.ValidationException;
import com.nav.add.store.CampaignMap;

@RestController
@RequestMapping(value="/add")
public class AddController {

	Logger logger = LoggerFactory.getLogger(AddController.class);

	@RequestMapping(value = "/{partner_id}", method = RequestMethod.GET)
	ResponseEntity<Partner> getById(@PathVariable String partner_id) throws ValidationException {
		System.out.println("from GET ========================");
		if (CampaignMap.getCampaignMap().containsKey(partner_id)) {
			return new ResponseEntity<Partner>(
					CampaignMap.getCampaignMap().get(partner_id), 
					HttpStatus.OK);

		} else {

			throw new ValidationException("Campaing for this partner id does not exist");
		}
	}
	
	

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Partner> addById(@RequestBody Partner partner) throws ValidationException {

		System.out.println("from POST ========================");

		if (partner == null)
			throw new ValidationException("partner cannot be null");
		if (CampaignMap.getCampaignMap().containsKey(partner.getPartner_id())) {
			throw new ValidationException("only one campain allowed per partner");
		} else {

			CampaignMap.getCampaignMap().put(partner.getPartner_id(), partner);
			return new ResponseEntity<Partner>(partner, HttpStatus.OK);
		}
	}
}
