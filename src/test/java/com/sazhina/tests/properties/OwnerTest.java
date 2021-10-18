package com.sazhina.tests.properties;

import com.sazhina.config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
class OwnerTest {
    public CredentialsConfig credentials =
            ConfigFactory.create(CredentialsConfig.class);

    @Test
    void readCredentialTest() {
        String username = credentials.username();
        String password = credentials.password();
        String Url = System.getProperty("Url", "selenoid.autotests.cloud/wd/hub/");


        System.out.println(username);
        System.out.println(password);
        String message = format("https://%s:%s@%s", username, password, Url);
        System.out.println(message);
    }
}
