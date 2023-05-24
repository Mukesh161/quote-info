package com.cts.service;

import com.cts.entity.QuoteInfo;

public interface QuoteInfoService {

	public void create(QuoteInfo quoteInfo);

	public QuoteInfo read(int ssn);

	public void update(QuoteInfo quoteInfo);

	public void delete(int systemId);

}
