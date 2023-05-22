package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.QuoteInfo;
import com.cts.service.QuoteInfoService;

@RestController
@RequestMapping("/quote-info")
public class QuoteInfoController {

	@Autowired
	private QuoteInfoService quoteInfoService;

	@PostMapping("/submitUW")
	public void create(QuoteInfo quoteInfo) {
		quoteInfoService.create(quoteInfo);
	}

	@GetMapping("/getQuoteStatus")
	public QuoteInfo read(int ssn) {
		return quoteInfoService.read(ssn);
	}
}
