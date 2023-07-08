package org.hookingconcepts.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HookingServiceTest {

    @InjectMocks
    private HookingService hookingService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMessage() {
        String ans = hookingService.getMessage();
        assertNotNull(ans);
    }
}
