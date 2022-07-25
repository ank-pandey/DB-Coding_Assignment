package com.trade.coding.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trade.coding.entity.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String>{

}
