package com.lahiru;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CorporateAccountTest {
    @Test
    public void should_ReturnTransactionId_IfTotalPriceLesserThanTotalPrice(){
        Account account=new PersonalAccount();
        int transactionId = account.authorizeTransaction(5);
        boolean result=transactionId>0;
        assertThat(result,is(true));
    }

    @Test
    public void should_ReturnTransactionId_IfTotalPriceEqualToTotalPrice(){
        Account account=new CorporateAccount();
        int transactionId = account.authorizeTransaction(30000);
        boolean result=transactionId>0;
        assertThat(result,is(true));
    }

    @Test
    public void should_ReturnZero_IfTotalPriceHigherThanTotalPrice(){
        Account account=new CorporateAccount();
        int transactionId = account.authorizeTransaction(30001);
        assertThat(transactionId,is(0));
    }

    @Test
    public void should_ReturnTrue_IfTransactionIsCanceled(){
        Account account=new CorporateAccount();
        int transactionId = account.authorizeTransaction(200);
        boolean result = account.cancelTransaction(transactionId);
        assertThat(result,is(true));
    }

    @Test
    public void should_ReturnTrue_IfTransactionIsConfirmed(){
        Account account=new PersonalAccount();
        int transactionId = account.authorizeTransaction(200);
        boolean result = account.confirmTransaction(transactionId);
        assertThat(result,is(true));
    }
}
