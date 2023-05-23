package com.cts.entity;

public class QuoteInfo {

	private int systemId;
	private String memberCounty;
	private String entityType;
	private String firstName;
	private String lastName;
	private String dob;
	private int ssn;
	private String address1;
	private String address2;
	private String county;
	private int primaryPhone;
	private int secondaryPhone;
	private String emailAddress;
	private String quoteStatus;
	private String lobInterested;
	private String premiumRange;

	public QuoteInfo() {
	}

	public QuoteInfo(String quoteStatus, String lobInterested, String premiumRange) {
		super();
		this.quoteStatus = quoteStatus;
		this.lobInterested = lobInterested;
		this.premiumRange = premiumRange;
	}

	public QuoteInfo(int systemId, String memberCounty, String entityType, String firstName, String lastName,
			String dob, int ssn, String address1, String address2, String county, int primaryPhone, int secondaryPhone,
			String emailAddress, String quoteStatus, String lobInterested, String premiumRange) {
		super();
		this.systemId = systemId;
		this.memberCounty = memberCounty;
		this.entityType = entityType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
		this.address1 = address1;
		this.address2 = address2;
		this.county = county;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.emailAddress = emailAddress;
		this.quoteStatus = quoteStatus;
		this.lobInterested = lobInterested;
		this.premiumRange = premiumRange;
	}

	public QuoteInfo(String memberCounty, String entityType, String firstName, String lastName, String dob, int ssn,
			String address1, String address2, String county, int primaryPhone, int secondaryPhone, String emailAddress,
			String quoteStatus, String lobInterested, String premiumRange) {
		super();
		this.memberCounty = memberCounty;
		this.entityType = entityType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.ssn = ssn;
		this.address1 = address1;
		this.address2 = address2;
		this.county = county;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.emailAddress = emailAddress;
		this.quoteStatus = quoteStatus;
		this.lobInterested = lobInterested;
		this.premiumRange = premiumRange;
	}

	public int getSystemId() {
		return systemId;
	}

	public void setSystemId(int systemId) {
		this.systemId = systemId;
	}

	public String getMemberCounty() {
		return memberCounty;
	}

	public void setMemberCounty(String memberCounty) {
		this.memberCounty = memberCounty;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public int getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public int getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(int secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getQuoteStatus() {
		return quoteStatus;
	}

	public void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	public String getLobInterested() {
		return lobInterested;
	}

	public void setLobInterested(String lobInterested) {
		this.lobInterested = lobInterested;
	}

	public String getPremiumRange() {
		return premiumRange;
	}

	public void setPremiumRange(String premiumRange) {
		this.premiumRange = premiumRange;
	}

}
