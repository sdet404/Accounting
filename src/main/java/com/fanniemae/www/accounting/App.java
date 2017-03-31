package com.fanniemae.www.accounting;

import java.sql.SQLException;
import java.util.Scanner;

import com.fanniemae.www.accounting.accountDAO.AccountDAO;
import com.fanniemae.www.accounting.accountDAO.IAccountDAO;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		final String CREATE_OPTION = "CREATE";
		final String UPDATE_OPTION = "UPDATE";
		final double INIT_DEPOSIT = 100d;

		boolean isMenu = true;
		Scanner scan = new Scanner(System.in);
		IAccountDAO accountDAO = new AccountDAO();

		while (isMenu) {
			System.out.println("Please select from the following options:");
			System.out.println("[CREATE] to create account.");
			System.out.println("[UPDATE] to update account.");
			System.out.println("Press [Q] to quit.");
			String option = scan.nextLine();

			if (option.equalsIgnoreCase(CREATE_OPTION)) {
				System.out.println("Enter name:");
				String name = scan.nextLine();
				if (accountDAO.create(name, INIT_DEPOSIT))
					System.out.println("Account for " + name + " created successfully.\n");
				else
					System.out.println("ERROR: Account was not created.\n");
			} else if (option.equalsIgnoreCase(UPDATE_OPTION)) {
				System.out.println("Enter account #:");
				String accountID = scan.nextLine();
				System.out.println("Enter new balance:");
				String accountBalance = scan.nextLine();
				if (accountDAO.update(Integer.parseInt(accountID), Double.parseDouble(accountBalance)))
					System.out.println("Account #" + accountID + " has been updated successfully.\n");
				else
					System.out.println("ERROR: Account was not updated.\n");
			} else if (option.equalsIgnoreCase("Q")) {
				isMenu = false;
				scan.close();
			}
		}

		System.out.println("Exited.");
	}

}
