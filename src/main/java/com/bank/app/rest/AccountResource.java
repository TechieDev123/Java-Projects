package com.bank.app.rest;

import com.bank.app.model.AccountInfo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/hdfc/accounts")
public class AccountResource {
    @GET
    @Path("/{account-no}")
    public String getBalance(@PathParam("account-no") String accountNo,
                             @MatrixParam("mobile-no") String mobileNo,
                             @CookieParam("account-holder-name") String accountHolderName) {
        System.out.println("Get Request Recieved");
        return "Your balance :: " + 690000.0f + " in Account :: " + accountNo+ " mobile no :: "+ mobileNo+ " account holder name :: " + accountHolderName;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createAccount(AccountInfo accountInfo){
        //Store in HDFC Accounts Database
        return "Account created successfully with the accountNumber :: "+ UUID.randomUUID()+" for :: "+accountInfo.getAccountHolderName();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AccountInfo updateAccount(AccountInfo accountInfo){
        //Get Existing Account data from database using accountInfo.getAccountNo();
        //compare the client account data and database account data
        //update the data and store in database
        return accountInfo;
    }

    @DELETE
    @Path("/{account-no}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public AccountInfo closeAccount(@PathParam("account-no") String accountNo){
        //get account from db using accountNo
        //delete the Account
        return new AccountInfo("Mahesh","saving", "CLOSED","SBI","398974","947847",0.0f);
    }
}

