package com.fanniemae.www.accounts.accountDAO;

import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fanniemae.www.accounting.accountDAO.AccountDAO;
import com.fanniemae.www.accounting.accountDAO.IAccountDAO;

public class AccountDAOTest {
	private IAccountDAO accountDAO;

	@Before
	public void setup() {
		accountDAO = new AccountDAO();
	}

	@Test
	public void createTestPass() throws ClassNotFoundException, SQLException {
		final double INIT_DEPOSIT = 100;
		long startTime = System.nanoTime();
		boolean isSuccess = accountDAO.create("Ted", INIT_DEPOSIT);
		long endTime = System.nanoTime();
		long timeTaken = (endTime - startTime) / 1000000;
		Assert.assertTrue(isSuccess);
		Assert.assertTrue("Took too long to create account.", timeTaken < 100);
	}

	@Test
	public void updateTestFail() throws ClassNotFoundException, SQLException {
		final int ACCOUNT_ID_DNE = -1;
		final double ACCOUNT_BAL = 999.99;
		boolean isSuccess = accountDAO.update(ACCOUNT_ID_DNE, ACCOUNT_BAL);
		Assert.assertTrue(!isSuccess);
	}

	@Test
	public void updateTestPass() throws ClassNotFoundException, SQLException {
		final int EXISTING_ACCOUNT_ID = 1001;
		final double ACCOUNT_BAL = 999.99;
		long startTime = System.nanoTime();
		boolean isSuccess = accountDAO.update(EXISTING_ACCOUNT_ID, ACCOUNT_BAL);
		long endTime = System.nanoTime();
		long timeTaken = (endTime - startTime) / 1000000;
		Assert.assertTrue(isSuccess);
		Assert.assertTrue("Took too long to update account.", timeTaken < 100);
	}

}
