package com.db.grp.svc;

import java.util.List;
import java.util.Map;

import com.db.grp.dto.Trade;

public interface TradeService {

	List<Trade> save(Trade trade) throws Exception;
	boolean validate(Trade newTrade) throws Exception ;
	List<Trade> getTrades();
	Map<String, List<Trade>> getTradeCache();

}
