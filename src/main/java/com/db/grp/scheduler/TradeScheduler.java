package com.db.grp.scheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.db.grp.svc.TradeService;

public class TradeScheduler {

	@Autowired
	private TradeService tradeService;
	
	@Scheduled(cron = "0 0 0 * * *")
	public void checkAndSetExpiryFlag() {
		tradeService.getTradeCache().forEach((key, value) ->{
			value.forEach(trade->{
				  if(trade.getMaturityDate() .isBefore(LocalDate.now()))
						trade.setExpiryFlag("Y");
				});
			
		});
		
		
		
	}
}
