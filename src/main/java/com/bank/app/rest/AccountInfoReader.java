package com.bank.app.rest;

import com.bank.app.model.AccountInfo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class AccountInfoReader implements MessageBodyReader<AccountInfo> {
    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public AccountInfo readFrom(Class<AccountInfo> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(AccountInfo.class);
            Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
            return (AccountInfo) unmarshaller.unmarshal(inputStream);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new IOException();
        }
    }
}
