package com.bank.app.converters;

import com.bank.app.model.AccountInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class AccountInfoXmlWriter implements MessageBodyWriter<AccountInfo> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public void writeTo(AccountInfo accountInfo, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AccountInfo.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(accountInfo, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
