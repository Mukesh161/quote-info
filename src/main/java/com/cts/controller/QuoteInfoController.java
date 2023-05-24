package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.QuoteInfo;
import com.cts.exceptions.InvalidInfo;
import com.cts.exceptions.SsnNotFound;
import com.cts.service.QuoteInfoService;

@RestController
@RequestMapping("/quote-info")
public class QuoteInfoController {

	@Autowired
	private QuoteInfoService quoteInfoService;

	@PostMapping("/submitUW")
	public ResponseEntity<String> create(@RequestBody QuoteInfo quoteInfo) throws InvalidInfo {
		try {
			quoteInfoService.create(quoteInfo);
			return new ResponseEntity<String>("Quote created", HttpStatus.OK);
		} catch (Exception e) {
			throw new InvalidInfo();
		}
	}

	@GetMapping("/getQuoteStatus/{ssn}")
	public ResponseEntity<QuoteInfo> read(@PathVariable int ssn) throws SsnNotFound {
		try {
			return new ResponseEntity<QuoteInfo>(quoteInfoService.read(ssn), HttpStatus.OK);
		} catch (Exception e) {
			throw new SsnNotFound(ssn);
		}
	}

	@ExceptionHandler(SsnNotFound.class)
	public ResponseEntity<?> handleSsnNotFound(SsnNotFound e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidInfo.class)
	public ResponseEntity<?> handleInvalidInfo(InvalidInfo e) {
		return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
	}
}
