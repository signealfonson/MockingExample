package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    @Test
    void payEmployees() {
    }
}