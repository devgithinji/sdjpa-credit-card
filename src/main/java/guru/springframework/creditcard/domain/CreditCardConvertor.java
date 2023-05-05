package guru.springframework.creditcard.domain;

import guru.springframework.creditcard.config.SpringContextHelper;
import guru.springframework.creditcard.service.EncryptionService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CreditCardConvertor implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String s) {
        return getEncryptionService().encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return getEncryptionService().decrypt(s);
    }


    private EncryptionService getEncryptionService() {
        return SpringContextHelper.getApplicationContext().getBean(EncryptionService.class);
    }
}
