package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("1", 10.0);

    @Test
    void getId() {
        assertThat(employee.getId()).isEqualTo("1");
    }

    @Test
    void setId() {
        employee.setId("2");
        assertEquals("2", employee.getId());
    }

    @Test
    void getSalary() {
        assertEquals(10.0, employee.getSalary());
    }

    @Test
    void setSalary() {
        employee.setSalary(20.0);
        assertEquals(20.0, employee.getSalary());
    }

    @Test
    void isPaid() {
        assertFalse(employee.isPaid());
    }

    @Test
    void setPaid() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void testToString() {
        assertEquals("Employee [id=1, salary=10.0]", employee.toString());
    }
}