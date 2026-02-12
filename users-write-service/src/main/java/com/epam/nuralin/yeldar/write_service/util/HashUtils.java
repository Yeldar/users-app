package com.epam.nuralin.yeldar.write_service.util;

import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
public class HashUtils {

    private static final byte[] EMPTY_ARRAY = new byte[0];

    public static byte[] sha256(String string) throws NoSuchAlgorithmException {
        if (string == null) {
            return EMPTY_ARRAY;
        }
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(string.getBytes(StandardCharsets.UTF_8));
    }
}
