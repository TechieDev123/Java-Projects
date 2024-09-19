package com.bank.app.rest;

import jakarta.ws.rs.*;

import java.util.UUID;

@Path("/hdfc/accounts")
public class AccountService {
    @GET
    @Path("/{account-no}")
    public String getBalance(@PathParam("account-no") String accountNo,
                             @MatrixParam("mobile-no") String mobileNo,
                             @CookieParam("account-holder-name") String accountHolderName) {
        return "Your balance :: " + 690000.0f + " in Account :: " + accountNo+ " mobile no :: "+ mobileNo+ " account holder name :: " + accountHolderName;
    }

    @POST
    public String createAccount(AccountInfo accountInfo){
        //Store in HDFC Accounts Database
        return "Account created successfully with the accountNumber :: "+ UUID.randomUUID()+" for :: "+accountInfo.getAccountHolderName();
    }
}