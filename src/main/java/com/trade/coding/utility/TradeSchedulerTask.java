package com.trade.coding.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.trade.coding.service.TradeService;

/**
 * this class will update expired flag at every 30 mins.
 *
 */
@Component
public class TradeSchedulerTask {

	@Autowired
	TradeService service;
	
	@Scheduled(cron = "${trade.expiry.schedule}")
	public void updateTrade() {
		service.updateExpiredFlag();
	}
}
