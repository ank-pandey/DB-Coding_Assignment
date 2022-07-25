package com.trade.coding.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TradeData")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
	
	@Id
	@Column(name = "Trade Id")
	private String tradeId;
	
	@Column(name = "Version")
	private int version;
	
	@Column(name = "Counter-Party Id")
	private String counterPartyId;
	
	@Column(name = "Book-Id")
	private String bookId;
	
	@Column(name = "Maturity Date")
	private LocalDate maturityDate;
	
	@Column(name = "Created Date")
	private LocalDate createdDate;
	
	@Column(name = "Expired")
	private String expired;

}
