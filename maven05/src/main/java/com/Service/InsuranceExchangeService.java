package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BaseDao;
import com.Entity.InsuranceExchange;

@Service
public class InsuranceExchangeService {
    @Autowired private BaseDao< InsuranceExchange> dao;
    
    public void add(InsuranceExchange insuranceExchange)
    {
    	dao.save(insuranceExchange);
    }
    public void update(InsuranceExchange insuranceExchange)
    {
    	dao.update(insuranceExchange);
    }
    public void delete(InsuranceExchange insuranceExchange)
    {
    	dao.delete(insuranceExchange);
    }
    public List<InsuranceExchange> getAll()
    {
    	return (List<InsuranceExchange>) dao.findAll("InsuranceExchange");
    }
    
    
    
}
