/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.predix.dbaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ge.predix.model.LocoSummary;
 
@Component("restClient")
public class RESTClient {
    @Autowired
    private RestTemplate restTemplate;
 
    public LocoSummary getLocoSum() {
        return restTemplate.getForObject("https://translocosummary.run.aws-usw02-pr.ice.predix.io/getLocoSummary", LocoSummary.class);
    }
}
