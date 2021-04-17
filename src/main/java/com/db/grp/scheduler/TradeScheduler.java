package com.db.grp.scheduler;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.db.grp.svc.TradeService;

public class TradeScheduler {

	@Autowired
	private TradeService tradeService;
	
	/**
	 * Run everyday 12AM to check if the maturity date less than current date 
	 * to set the expiry flag to Y
	 * @return
	 */
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
