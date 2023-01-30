package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee;

    @BeforeEach
    void beforeEveryTest() {
        employee = new Employee("1", 10.0);
    }

    @Test
    void getIdShouldReturnOneWhenIdIsSetToOne() {
        // Given
        employee.setId("1");

        // When
        String id = employee.getId();

        // Then
        assertThat(id).isEqualTo("1");
    }

    @Test
    void setId() {
        employee.setId("2");
        assertEquals("2", employee.getId());
    }

    @Test
    void getSalaryShouldReturnTenWhenSalaryIsSetToTen() {
        employee.setSalary(10.0);
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
    void toStringShouldReturnFullDescription() {
        assertEquals("Employee [id=1, salary=10.0]", employee.toString());
    }
}