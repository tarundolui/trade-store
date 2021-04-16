package com.db.grp.svc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import static java.util.Comparator.comparing;

import com.db.grp.dto.Trade;
import com.db.grp.exception.MaturityDateException;
import com.db.grp.exception.TradeVersionException;


@Service
public class TradeServiceImpl implements TradeService{

	Map<String, List<Trade>> tradeCache = new HashMap<>();

	public List<Trade> save(Trade trade) throws Exception {
		validate(trade);
		trade.setCreatDate(LocalDate.now());
		if(CollectionUtils.isEmpty(tradeCache.get(trade.getTradeId()))) {
			List<Trade> trades = new ArrayList<>();
			trades.add(trade);
			tradeCache.put(trade.getTradeId(), trades);
		}else {
				tradeCache.get(trade.getTradeId()).removeIf(p -> p.getTradeId().equals(trade.getTradeId()) 
		    		&& (p.getVersion() == trade.getVersion())); 
			
				tradeCache.get(trade.getTradeId()).add(trade);
		}


		return getTrades();

	}


	public boolean validate(Trade newTrade) throws Exception {

		if(newTrade.getMaturityDate().isBefore(LocalDate.now())) 
			throw new MaturityDateException();
		
		if(tradeCache.isEmpty())
			return true;

		List<Trade> trades = tradeCache.get(newTrade.getTradeId());
		
		if(!CollectionUtils.isEmpty(trades)) {
			for(Trade trade : trades) {
				if(newTrade.getVersion() < trade.getVersion())
					throw new TradeVersionException();
				}
		}
		
		return true;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Trade> getTrades(){
		
		 List<Trade> listOfTrades = new ArrayList();
		 tradeCache.forEach((key, value) -> listOfTrades.addAll(value));

		 Comparator<Trade> compareByName = Comparator
                 .comparing(Trade::getTradeId)
                 .thenComparing(comparing(Trade::getVersion).reversed());

		List<Trade> sortedEmployees = listOfTrades.stream()
			         .sorted(compareByName)
					.collect(Collectors.toList());

		  
		return sortedEmployees;		
		
		

	}


	public Map<String, List<Trade>> getTradeCache() {
		return tradeCache;
	}


	
	
	

}
