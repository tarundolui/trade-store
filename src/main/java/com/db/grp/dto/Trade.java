package com.db.grp.dto;

import java.time.LocalDate;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Trade {

	private String tradeId;
	private int version;
	private String counterPartyId;
	private String bookId;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate maturityDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate creatDate;
	
	private String expiryFlag = "N";
	
	public String getTradeId() {
		return tradeId;
	}
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(LocalDate creatDate) {
		this.creatDate = creatDate;
	}
	public String getExpiryFlag() {
		return expiryFlag;
	}
	public void setExpiryFlag(String expiryFlag) {
		this.expiryFlag = expiryFlag;
	}
	
	
	public String toString() {
		return this.getTradeId() + " "+this.getVersion();
	}
	
}
