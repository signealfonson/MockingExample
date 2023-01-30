package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;

class EmployeesTest {
    BankService bankService = Mockito.mock(BankService.class);
    EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
    Employees employees = new Employees(employeeRepository, bankService);
    Employee e = new Employee("1", 10.0);
    Employee f = new Employee("2", 15.0);

    @BeforeEach
    void beforeEveryTest() {
        employeeRepository.save(e);
        employeeRepository.save(f);
    }
    @Test
    void payEmployees() {
        assertEquals(2,employees.payEmployees());
    }
    @Test
    void controlPayment() {
        employees.payEmployees();
        assertTrue(e.isPaid());
    }
    @Test
    void testRuntimeException(){
        doThrow(RuntimeException.class).when(bankService).pay(e.getId(),e.getSalary());
        employees.payEmployees();

        assertFalse(e.isPaid());
    }
}