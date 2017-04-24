package pl.edu.agh.soa.lab5.zad2.model.validator;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class CustomValidationEventHandler implements ValidationEventHandler {
    @Override
    public boolean handleEvent(ValidationEvent event) {
        System.out.println("Opis: " + event.getMessage());
        System.out.println("URL: " + event.getLocator().getURL().toString());
        System.out.println("Linia: " + event.getLocator().getLineNumber() + "; kolumna: " + event.getLocator().getColumnNumber());
        return false;
    }
}
