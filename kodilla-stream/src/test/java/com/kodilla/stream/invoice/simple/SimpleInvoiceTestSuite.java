package com.kodilla.stream.invoice.simple;

import org.junit.Assert;
import org.junit.Test;

public class SimpleInvoiceTestSuite {
    @Test
    public void testGetValueToPay() {
        //Given
        SimpleInvoice invoice = new SimpleInvoice();
        //When
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 1", 20.99), 2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 2", 45.11), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 3",  34.90), 5.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("Product 4",  55.90), 5.0));
        //Then
        Assert.assertEquals(653.865, invoice.getValueToPay(), 0.001);
    }
}