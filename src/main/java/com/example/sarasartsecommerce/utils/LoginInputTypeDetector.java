package com.example.sarasartsecommerce.utils;

import com.example.sarasartsecommerce.models.LoginInput;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Getter;

import static org.apache.commons.validator.GenericValidator.isEmail;

@Getter
public class LoginInputTypeDetector {
    private final LoginInput loginInput;
    public LoginInputTypeDetector(String login) throws NumberParseException {
        if (isEmail(login)) loginInput = LoginInput.EMAIL;
        else if (isPhoneNumber(login)) loginInput = LoginInput.PHONE_NUMBER;
        else loginInput = LoginInput.ERROR;
    }

    private Boolean isPhoneNumber(String phoneNumber) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phoneNumber, null));
    }
}
