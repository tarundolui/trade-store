package com.db.grp.svc;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.db.grp.dto.Trade;
import com.db.grp.exception.MaturityDateException;
import com.db.grp.exception.TradeVersionException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TradeServiceTest {

	@Autowired
	private TradeService tradeService;

	@BeforeEach
    public void init() {
       tradeService.getTradeCache().clear();
    }
	
	/**
	 * Test the validate functionality for trade
	 * @throws Exception
	 */
	@Test
	public void testValidate() throws Exception{
		Trade trade = new Trade();
		trade.setTradeId("1");
		trade.setVersion(1);
		trade.setMaturityDate(LocalDate.now());
		boolean status = tradeService.validate(trade);
		Assertions.assertEquals(status, true);
		
	}
	
	
	/**
	 * Test the validate functionality for exception scenario
	 * where trade lower version received later
	 * @throws Exception
	 */
	
	@Test
	public void testValidateException() throws Exception{
		Trade trade = new Trade();
		trade.setTradeId("1");
		trade.setVersion(2);
		trade.setMaturityDate(LocalDate.now());
		tradeService.save(trade);
		
		Trade trade1 = new Trade();
		trade1.setTradeId("1");
		trade1.setVersion(1);
		trade1.setMaturityDate(LocalDate.now());
		
		
		Assertions.assertThrows(TradeVersionException.class, () -> {
			tradeService.validate(trade1);
		  });
		
	}
	
	/**
	 * Test the validate functionality for exception scenario
	 * where trade Maturity date is less than current day
	 * @throws Exception
	 */
	@Test
	public void testMaturityException() throws Exception{
		Trade trade = new Trade();
		trade.setTradeId("1");
		trade.setVersion(1);
		trade.setMaturityDate(LocalDate.of(2019, 10, 10));
	
		Assertions.assertThrows(MaturityDateException.class, () -> {
			tradeService.validate(trade);
		  });
		
	}
	
	/**
	 * Test the  save
	 * where trade lower version received later
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception{
		Trade trade = new Trade();
		trade.setTradeId("1");
		trade.setVersion(2);
		trade.setMaturityDate(LocalDate.now());
		List<Trade> allTrades = tradeService.save(trade);
		Assertions.assertEquals(allTrades.size(), 1);
		
	}

}
