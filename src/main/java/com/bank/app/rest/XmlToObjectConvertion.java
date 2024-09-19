package com.bank.app.rest;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlToObjectConvertion {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext=JAXBContext.newInstance(AccountInfo.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        AccountInfo accountInfo= (AccountInfo) unmarshaller.unmarshal(new File("C:\\Users\\techi\\IdeaProjects\\HDFCBank\\data.xml"));
        System.out.println(accountInfo);
    }
}
