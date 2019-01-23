package com.ks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ks.client.model.TransactionRequest;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException
    {
        String value = "";
        TransactionRequest transactionRequest = new ObjectMapper().readValue(value, TransactionRequest.class);
        System.out.println(transactionRequest.toString());
        assertTrue(true);
    }
}
