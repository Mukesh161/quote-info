package com.cts.dao;

import com.cts.entity.QuoteInfo;

public interface QuoteInfoDAO {

	public void create(QuoteInfo quoteInfo);

	public QuoteInfo read(int ssn);

	public void update(QuoteInfo quoteInfo);

	public void delete(int systemId);

}
