package com.trade.coding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trade.coding.entity.Trade;
import com.trade.coding.exception.InvalidTradeException;
import com.trade.coding.service.TradeService;

@RestController

@RequestMapping("/api/v1")
public class TradeController {
	
	@Autowired
	private TradeService service;
	
	@PostMapping("/trade")
	public ResponseEntity<String> tradeValidate(@RequestBody Trade trade) throws InvalidTradeException{
		if(service.isValid(trade)) {
			service.persist(trade);
		}else {
		
			throw new InvalidTradeException(trade.getTradeId()+" Trade Id is not found");
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/trade")
	public List<Trade> findTrades(){
		
		return new ArrayList<>();
	}

}
