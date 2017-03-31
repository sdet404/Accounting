package com.fanniemae.www.accounting.accountDAO;

import java.sql.SQLException;

public interface IAccountDAO {

	public boolean create(String name, double accountBalance) throws ClassNotFoundException, SQLException;

	public boolean update(Integer accountID, double accountBalance) throws ClassNotFoundException, SQLException;

}
