package com.trade.coding.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trade.coding.entity.Trade;
import com.trade.coding.repo.TradeRepository;

@Service
public class TradeService {
	
	@Autowired
	private TradeRepository tradeRepo;
	
	
	public boolean isValid(Trade trade) {
		
		if(validateMaturityDate(trade)) {
			
			Optional<Trade> existingTrade = tradeRepo.findById(trade.getTradeId());
			if(existingTrade.isPresent()) {
				return validateVersion(trade, existingTrade.get());
			}else {
				return true;
			}
			
		}
		return false;
	}
	
	private boolean validateVersion(Trade trade, Trade trade2) {

		if(trade.getVersion() >= trade2.getVersion()) {
			return true;
		}
		return false;
	}

	private boolean validateMaturityDate(Trade trade) {
		return trade.getMaturityDate().isBefore(LocalDate.now()) ? false : true;
	}

	public void persist(Trade trade) {
		trade.setCreatedDate(LocalDate.now());
		tradeRepo.save(trade);
	}
	
	public List<Trade> findAll(){
		
		return tradeRepo.findAll();
	}
	
	public void updateExpiredFlag() {
		
		tradeRepo.findAll().stream().forEach(t -> {
			
			if(! validateMaturityDate(t)) {
				t.setExpired("Y");
				tradeRepo.save(t);
			}
		});
	}
}
