package sprint1.pbms;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import sprint1.pbms.dao.TransactionDao;
import sprint1.pbms.dao.TransactionDaoImpl;
import sprint1.pbms.model.TransactionUsingSlip;

public class pbmsTest {
	TransactionDao td=new TransactionDaoImpl();
	Map<String,TransactionUsingSlip> transaction=new HashMap<String,TransactionUsingSlip>();
	@Test
	public void creditTest() {
		 assertEquals(true,td.creditUsingSlip("Rebeca", "123456789012",  200));
	}
	@Test
	public void debitTest() {
		 assertEquals(true,td.debitUsingSlip("Rebeca", "123456789012",  200));
	}
	@Test
	public void addTest() {
		 assertEquals(true,td.addAmount("123456789012", 2000));
	}
	@Test
	public void deductTest() {
		 assertEquals(true,td.deductAmount("123456789012", 2000));
	}
}
