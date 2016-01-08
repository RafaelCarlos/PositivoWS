package com.rafaelcarlos.positivo.util;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author rafaellcarloss
 */
public class Criptografia {

    public String criptografa(String user, String pwd) {

        String auth = user + ":" + pwd;
        String encodedAuth = Base64.encodeBase64String(auth.getBytes());

        return encodedAuth;
    }
}
