package com.cts.controller;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

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

import com.cts.entity.ExceptionResponse;
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
		if (!Stream.of(quoteInfo.getMemberCounty(), quoteInfo.getEntityType(), quoteInfo.getFirstName(),
				quoteInfo.getLastName(), quoteInfo.getDob(), (quoteInfo.getSsn() == 0) ? null : quoteInfo.getSsn(),
				quoteInfo.getAddress1(), quoteInfo.getAddress2(), quoteInfo.getCounty(),
				(quoteInfo.getPrimaryPhone() == 0) ? null : quoteInfo.getPrimaryPhone(),
				(quoteInfo.getSecondaryPhone() == 0) ? null : quoteInfo.getSecondaryPhone(),
				quoteInfo.getEmailAddress(), quoteInfo.getQuoteStatus(), quoteInfo.getLobInterested(),
				quoteInfo.getPremiumRange()).anyMatch((Objects::isNull))) {
			try {
				quoteInfoService.create(quoteInfo);
				return new ResponseEntity<String>("Quote created", HttpStatus.OK);
			} catch (Exception e) {
				throw new InvalidInfo("Invalid data passed");
			}
		} else {
			throw new InvalidInfo("Invalid data passed");
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
	public ResponseEntity<ExceptionResponse> handleSsnNotFound(SsnNotFound e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), new Date());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidInfo.class)
	public ResponseEntity<ExceptionResponse> handleInvalidInfo(InvalidInfo e) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(), new Date());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
