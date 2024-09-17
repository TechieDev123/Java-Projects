package com.bank.app.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/hdfc/accounts")
public class AccountService {
    @GET
    public String getBalance(@QueryParam("account-no") String accountNo) {
        return "Your balance :: " + 690000.0f + " in Account :: " + accountNo;
    }

    @GET
    @Path("/mobile")
    public String getBalance(@QueryParam("account-no") String accountNo, @QueryParam("mobile-no") String mobileNo) {
        return "Your balance :: " + 690000.0f + " in Account :: " + accountNo+" and mobile Number :: " + mobileNo;
    }
}