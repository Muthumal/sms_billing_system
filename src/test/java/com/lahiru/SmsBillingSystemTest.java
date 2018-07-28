package com.lahiru;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SmsBillingSystemTest {

    @Test
    public void should_ReturnTransactionId_IfAuthorizeReceiveTransactionId(){
        int simNo=716484641;
        Repository repository=mock(InMemoryRepository.class);
        BillingSystem smsBillingSystem=new SmsBillingSystem(repository);
        Account account=mock(PersonalAccount.class);
        double smsPrice = ((SmsBillingSystem) smsBillingSystem).getSmsPrice();

        when(repository.getById(simNo)).thenReturn(account);
        when(account.authorizeTransaction(smsPrice)).thenReturn(77552153);

        boolean result = smsBillingSystem.authorize(simNo)!=0;
        assertThat(result,is(true));
        verify(repository).getById(simNo);
        verify(account).authorizeTransaction(smsPrice);
    }

    @Test
    public void should_ReturnZero_IfAuthorizeReceiveZero(){
        int simNo=716484641;
        Repository repository=mock(InMemoryRepository.class);
        BillingSystem smsBillingSystem=new SmsBillingSystem(repository);
        Account account=mock(PersonalAccount.class);
        double smsPrice = ((SmsBillingSystem) smsBillingSystem).getSmsPrice();

        when(repository.getById(simNo)).thenReturn(account);
        when(account.authorizeTransaction(smsPrice)).thenReturn(0);

        boolean result = smsBillingSystem.authorize(simNo)!=0;
        assertThat(result,is(false));
        verify(repository).getById(simNo);
        verify(account).authorizeTransaction(smsPrice);
    }
}
