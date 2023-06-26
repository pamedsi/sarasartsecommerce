package com.example.sarasartsecommerce.validation;

import com.example.sarasartsecommerce.models.LoginInput;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

@NoArgsConstructor
@Getter
public class LoginInputValidator  {
    private LoginInput loginInput;

    private Boolean isPhoneNumber(String phoneNumber) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phoneNumber, null));
    }

    private Boolean isEmail(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

    public LoginInputValidator(String login) throws NumberParseException {
        if (isEmail(login)) loginInput = LoginInput.EMAIL;
        else if (isPhoneNumber(login)) loginInput = LoginInput.PHONE_NUMBER;
        else loginInput = LoginInput.ERROR;
    }

//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        return loginInput != LoginInput.ERROR;
//    }
}
