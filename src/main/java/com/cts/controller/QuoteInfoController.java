package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public void create(@RequestBody QuoteInfo quoteInfo) {
		quoteInfoService.create(quoteInfo);
	}

	@GetMapping("/getQuoteStatus/{ssn}")
	public QuoteInfo read(@PathVariable int ssn) {
		return quoteInfoService.read(ssn);
	}
}
