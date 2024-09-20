package com.bank.app.converters;

import com.bank.app.model.AccountInfo;
import com.fasterxml.jackson.databind.*;

import java.io.File;
import java.io.IOException;

public class Jackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper=new ObjectMapper();
        AccountInfo accountInfo=mapper.readValue(new File("C:\\Users\\techi\\IdeaProjects\\HDFCBank\\data.json"), AccountInfo.class);
        System.out.println(accountInfo);

        AccountInfo accountInfo1=new AccountInfo("mahesh","saving","ACTIVE","SBI","8875646464","UJLEJJ89K",898999.0f);
        String json=mapper.writeValueAsString(accountInfo1);
        System.out.println(json);
    }
}
