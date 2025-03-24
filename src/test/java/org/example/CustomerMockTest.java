package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Task3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerMockTest {

  private Customer customer;

  @Mock
  private CreditReport creditReportMock;
  @Mock
  private Loan loanMock;
  @Mock
  private Savings savingsMock;
  @Mock
  private Checking checkingMock;
  @Mock
  private Account accountMock;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    // Initialize Customer with mocked CreditReport
    when(creditReportMock.getScore(anyString())).thenReturn(700);
    customer = new Customer(creditReportMock, 1, "John Doe", 30, "123 Main St", 60000, "555-1234", "123-45-6789");
  }

  @Test
  public void testCreditReportInteractionInConstructor() {
    verify(creditReportMock).getScore("123-45-6789");
    assertEquals(700, customer.getCreditScore());
  }

  @Test
  public void testApplyForLoanInteraction() {
    // Setup mock behavior
    when(loanMock.getLt()).thenReturn(LoanType.Personal);
    when(loanMock.getAmount()).thenReturn(10000);
    when(loanMock.requestLoan(eq(customer), eq(LoanType.Personal), eq(10000))).thenReturn(loanMock);


    // Call method
    int amount = customer.applyForLoan(loanMock);

    // Verify interactions and behavior
    verify(loanMock).requestLoan(customer, LoanType.Personal, 10000);
    verify(loanMock).getLt();
    verify(loanMock, times(2)).getAmount(); // Expect 2 calls to getAmount()
    assertEquals(10000, amount);
  }


  @Test
  public void testApplyForSavingsAccountInteractions() {
    when(savingsMock.getBalance()).thenReturn(1000.0);
    when(savingsMock.open(eq(customer), eq(1000.0))).thenReturn(savingsMock);
    when(savingsMock.getInterestRate()).thenReturn(0.02);

    double interestRate = customer.applyForSavingsAccount(savingsMock);

    verify(savingsMock).getBalance();
    verify(savingsMock).open(customer, 1000.0);
    verify(savingsMock).getInterestRate();
    assertEquals(0.02, interestRate, 0.001);
  }

  @Test
  public void testApplyForCheckingAccountInteractions() {
    when(checkingMock.getBalance()).thenReturn(500.0);
    when(checkingMock.open(eq(customer), eq(500.0))).thenReturn(checkingMock);

    boolean result = customer.applyForCheckingAccount(checkingMock);

    verify(checkingMock).getBalance();
    verify(checkingMock).open(customer, 500.0);
    assertTrue(result);
  }

  @Test
  public void testCloseAccountInteraction() {




    // Setup: Add the mock Account to the customer's accounts list
    customer.getAccounts().add(accountMock);

    // Stub the behavior of destroy
    when(accountMock.destroy()).thenReturn(1000.0);
    when(accountMock.equals(accountMock)).thenReturn(true);

    // Call the method under test
    double amount = customer.closeAccount(accountMock);

    // Verify the interaction with destroy
    verify(accountMock).destroy();
    verify(accountMock).equals(accountMock);

    // Assert the result
    assertEquals(1000.0, amount, 0.001);
  }

  @Test
  public void testRequestCheckBookletInteraction() {
    // Setup: Add the mock Checking account to the customer's accounts list
    customer.getAccounts().add(checkingMock);

    // Stub the behavior of requestCheckBooklet
    when(checkingMock.requestCheckBooklet(5)).thenReturn(true);

    // Call the method under test
    boolean result = customer.requestCheckBooklet(checkingMock, 5);

    // Verify the interaction with requestCheckBooklet
    verify(checkingMock).requestCheckBooklet(5);

    // Assert the result
    assertTrue(result);
  }
}