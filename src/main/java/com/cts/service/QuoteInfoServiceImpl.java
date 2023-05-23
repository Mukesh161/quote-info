package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.QuoteInfoDAO;
import com.cts.entity.QuoteInfo;

@Service
public class QuoteInfoServiceImpl implements QuoteInfoService {
	
	@Autowired
	private QuoteInfoDAO dao;

	@Override
	public void create(QuoteInfo quoteInfo) {
		dao.create(quoteInfo);
	}

	@Override
	public QuoteInfo read(int ssn) {
		return dao.read(ssn);
	}

	@Override
	public void update(QuoteInfo quoteInfo) {
		dao.update(quoteInfo);
	}

	@Override
	public void delete(int systemId) {
		dao.delete(systemId);
	}

}
