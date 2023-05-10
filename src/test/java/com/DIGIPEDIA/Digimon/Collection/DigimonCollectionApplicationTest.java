package com.DIGIPEDIA.Digimon.Collection;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DigimonCollectionApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(applicationContext);
    }

    @Test
    public void entryPointTest() {
        assertDoesNotThrow(() -> DigimonCollectionApplication.main(new String[]{}));
    }
}