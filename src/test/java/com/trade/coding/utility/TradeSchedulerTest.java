package com.trade.coding.utility;



import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.awaitility.Awaitility;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.trade.coding.TradeAssignmentApplication;

@SpringJUnitConfig(TradeAssignmentApplication.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TradeSchedulerTest {

	@SpyBean
	private TradeSchedulerTask TradeSchedulerTask;
	
	@Test
	public void whenWait() {
		Awaitility.await().atMost(Durations.ONE_MINUTE).untilAsserted(() -> verify(TradeSchedulerTask,
				 atLeast(2)).updateTrade());
	}
}
