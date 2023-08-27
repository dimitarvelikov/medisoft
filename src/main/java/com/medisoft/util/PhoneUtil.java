package com.medisoft.util;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import lombok.extern.slf4j.Slf4j;

import static com.google.i18n.phonenumbers.Phonenumber.*;

@Slf4j
public class PhoneUtil {

    private static final PhoneNumberUtil PHONE_NUMBER_UTIL = PhoneNumberUtil.getInstance();

    public static boolean isValid(String phone, String countryCode) {
        try {
            PhoneNumber swissNumberProto = PHONE_NUMBER_UTIL.parse(phone, countryCode);
            return PHONE_NUMBER_UTIL.isValidNumber(swissNumberProto);
        } catch (Exception e) {
            log.warn("action=PhoneUtil.isValid status=error Could not validate phone number={} countryCode={}", phone, countryCode);
            return false;
        }
    }
}
