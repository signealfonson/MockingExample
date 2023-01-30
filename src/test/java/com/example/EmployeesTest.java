package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

class EmployeesTest {
    BankService bankService;
    EmployeeRepositoryImpl employeeRepository;
    Employees employees;
    Employee e;
    Employee f;

    @BeforeEach
    void beforeEveryTest() {
        bankService = Mockito.mock(BankService.class);
        employeeRepository = new EmployeeRepositoryImpl();
        employees = new Employees(employeeRepository, bankService);
        e = new Employee("1", 10.0);
        f = new Employee("2", 15.0);
        employeeRepository.save(e);
        employeeRepository.save(f);
    }
    @Test
    void payEmployees() {
        //Given

        //When
        int actual = employees.payEmployees();
        //Then
        verify(bankService).pay(eq("1"),anyDouble());
        verify(bankService).pay(eq("2"),anyDouble());
        assertEquals(2, actual);
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