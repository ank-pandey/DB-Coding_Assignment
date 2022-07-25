package com.trade.coding;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trade.coding.controller.TradeController;
import com.trade.coding.entity.Trade;
import com.trade.coding.exception.InvalidTradeException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TradeAssignmentApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	TradeController controller;
	
	@Test
	void testTradeSuccess() throws InvalidTradeException {
		ResponseEntity<String> responseEntity = controller.tradeValidate(setupTrade("T1",1,LocalDate.now()));
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(), responseEntity);
	}
	
	@Test
	void testTradewithMaturityPast() {
		LocalDate localDate  = LocalDate.of(2022, 06, 25);
		try{
			controller.tradeValidate(setupTrade("T2", 1, localDate));
		}
		catch(InvalidTradeException e) {
			Assertions.assertEquals("Invalid trade: T2 trade Id is not found", e.getMessage());
		}
	}
	
	private Trade setupTrade(String id, int version, LocalDate maturityDate) {
		Trade t = new Trade();
		t.setTradeId(id);
		t.setBookId(id+"B");
		t.setVersion(version);
		t.setCounterPartyId(id+"C");
		t.setMaturityDate(maturityDate);
		t.setExpired("Y");
		return t;
	}

}
