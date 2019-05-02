package org.games.stratego.Services;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.SecureRandom;

public class AntiCSRF {
    // Generate a random string to use as a CSRF token.
    public static String generateCSRFToken() {
        byte[] b = new byte[18];
        new SecureRandom().nextBytes(b);
        return Base64.encodeBase64URLSafeString(b);
    }
}
