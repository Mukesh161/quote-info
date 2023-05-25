package com.cts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.entity.QuoteInfo;

@Repository
public class QuoteInfoDAOImpl implements QuoteInfoDAO {

	private static final String SQL_CREATE = "insert into quoteinfo(member_county, entity_type, first_name, last_name, dob, ssn, address1, address2, county, primary_phone, secondary_phone, email_address, quote_status, lob_interested, premium_range) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_READ = "select * from quoteinfo where ssn = ?";
	private static final String SQL_UPDATE = "update quoteinfo set member_county=?, entity_type=?, first_name=?, last_name=?, dob=?, ssn=?, address1=?, address2=?, county=?, primary_phone=?, secondary_phone=?, email_address=?, quote_status=?, lob_interested=?, premium_range=? where system_id = ?";
	private static final String SQL_DELETE = "delete from quoteinfo where system_id = ?";
//	private static final String SQL_ID = "select max(id) as id from quoteinfo";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void create(QuoteInfo quoteInfo) {

		jdbcTemplate.update(SQL_CREATE, quoteInfo.getMemberCounty(), quoteInfo.getEntityType(),
				quoteInfo.getFirstName(), quoteInfo.getLastName(), quoteInfo.getDob(), quoteInfo.getSsn(),
				quoteInfo.getAddress1(), quoteInfo.getAddress2(), quoteInfo.getCounty(), quoteInfo.getPrimaryPhone(),
				quoteInfo.getSecondaryPhone(), quoteInfo.getEmailAddress(), quoteInfo.getQuoteStatus(),
				quoteInfo.getLobInterested(), quoteInfo.getPremiumRange());
	}

	@Override
	public QuoteInfo read(int ssn) {
		return jdbcTemplate.queryForObject(SQL_READ,
				(rs, rc) -> new QuoteInfo(rs.getInt("system_id"), rs.getString("member_county"),
						rs.getString("entity_type"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getDate("dob"), rs.getInt("ssn"), rs.getString("address1"), rs.getString("address2"),
						rs.getString("county"), rs.getInt("primary_phone"), rs.getInt("secondary_phone"),
						rs.getString("email_address"), rs.getString("quote_status"), rs.getString("lob_interested"),
						rs.getString("premium_range")),
				ssn);
	}

	@Override
	public void update(QuoteInfo quoteInfo) {
		jdbcTemplate.update(SQL_UPDATE, quoteInfo.getMemberCounty(), quoteInfo.getEntityType(),
				quoteInfo.getFirstName(), quoteInfo.getLastName(), quoteInfo.getDob(), quoteInfo.getSsn(),
				quoteInfo.getAddress1(), quoteInfo.getAddress2(), quoteInfo.getCounty(), quoteInfo.getPrimaryPhone(),
				quoteInfo.getSecondaryPhone(), quoteInfo.getEmailAddress(), quoteInfo.getQuoteStatus(),
				quoteInfo.getLobInterested(), quoteInfo.getPremiumRange(), quoteInfo.getSystemId());
	}

	@Override
	public void delete(int systemId) {
		jdbcTemplate.update(SQL_DELETE, systemId);
	}

}
