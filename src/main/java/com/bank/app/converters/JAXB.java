package com.bank.app.converters;


import com.bank.app.model.AccountInfo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.PrintStream;

public class JAXB {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext=JAXBContext.newInstance(AccountInfo.class);

        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        AccountInfo accountInfo= (AccountInfo) unmarshaller.unmarshal(new File("C:\\Users\\techi\\IdeaProjects\\HDFCBank\\data.xml"));
        System.out.println(accountInfo);

        Marshaller marshaller= jaxbContext.createMarshaller();
        AccountInfo accountInfo1=new AccountInfo("mahesh","saving","ACTIVE","SBI","8875646464","UJLEJJ89K",898999.0f);
        marshaller.marshal(accountInfo1, System.out);
    }
}
