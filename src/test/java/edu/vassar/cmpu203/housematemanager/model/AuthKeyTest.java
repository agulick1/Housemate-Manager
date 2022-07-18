package edu.vassar.cmpu203.housematemanager.model;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class AuthKeyTest {

    private static final String genPassword(final int length) {
        final byte[] password = new byte[length];
        new Random().nextBytes(password);
        return new String(password, StandardCharsets.UTF_8);
    }
    /*
    Tests validatePassword() by verifying a correct password is validated and a different one is not
     */
    @Test
    void validatePassword() {
        // TODO - fill this in
        for (int i = 0; i < 10; i++) { // repeat a couple times to avoid false positives
            String password = genPassword(32);
            String wrongPassword = genPassword(32);
            while (wrongPassword.equals(password)) {
                wrongPassword = genPassword(32);
            } // makes sure they are different
            AuthKey key = new AuthKey(password);
            assertTrue(key.validatePassword(password));
            assertFalse(key.validatePassword(wrongPassword));
        }
    }
}
