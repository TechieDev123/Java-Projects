package com.bank.app.rest;

import com.bank.app.model.AccountInfo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

@Path("/hdfc/accounts")
public class AccountResource {
    @GET
    @Path("/{account-no}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AccountInfo getAccountDetails(@PathParam("account-no") String accountNo, @MatrixParam("mobile-no") String mobileNo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdfc", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Accounts where accountNo=? and mobileNo=?");
            preparedStatement.setString(1, accountNo);
            preparedStatement.setString(2, mobileNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                AccountInfo accountInfo = new AccountInfo();
                accountInfo.setAccountNumber(resultSet.getString(2));
                accountInfo.setAccountHolderName(resultSet.getString(3));
                accountInfo.setAccountType(resultSet.getString(4));
                accountInfo.setAccountStatus(resultSet.getString(5));
                accountInfo.setBranch(resultSet.getString(6));
                accountInfo.setPhoneNumber(resultSet.getString(7));
                accountInfo.setPanCard(resultSet.getString(8));
                accountInfo.setBalance(resultSet.getFloat(9));
                return accountInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Account Details not found");
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createAccount(AccountInfo accountInfo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdfc", "root", "root");
            PreparedStatement preparedStatement = connection.prepareStatement("insert into accounts(accountNo,accountHolderName,accountType,accountStatus,branch,mobileNo,panCard,balance) values(?,?,?,?,?,?,?,?)");
            String accountNo = UUID.randomUUID().toString();
            preparedStatement.setString(1, accountNo);
            preparedStatement.setString(2, accountInfo.getAccountHolderName());
            preparedStatement.setString(3, accountInfo.getAccountType());
            preparedStatement.setString(4, accountInfo.getAccountStatus());
            preparedStatement.setString(5, accountInfo.getBranch());
            preparedStatement.setString(6, accountInfo.getPhoneNumber());
            preparedStatement.setString(7, accountInfo.getPanCard());
            preparedStatement.setFloat(8, accountInfo.getBalance());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                return "Account created successfully with accountNo :: " + accountNo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Account creation failed, please check the details again";
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountInfo updateAccount(AccountInfo accountInfo) {
        //Get Existing Account data from database using accountInfo.getAccountNo();
        //compare the client account data and database account data
        //update the data and store in database
        return accountInfo;
    }

    @DELETE
    @Path("/{account-no}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountInfo closeAccount(@PathParam("account-no") String accountNo) {
        //get account from db using accountNo
        //delete the Account
        return new AccountInfo();
    }
}

