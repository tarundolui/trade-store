package com.db.grp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.grp.dto.Trade;
import com.db.grp.svc.TradeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TradeController {

	Logger logger = LogManager.getLogger(TradeController.class);
	
	@Autowired
	private TradeService tradeService;
	

	@PostMapping("/send")
	public List<Trade> send(@RequestBody Trade trade) throws Exception {
		return tradeService.save(trade);
	
	}
}
