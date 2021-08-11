package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.model.Employee;
import com.thoughtworks.springbootemployee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void should_return_all_employees_when_getAllEmployees_given_all_employees() {
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "russel", 22, "male", 1000));
        employees.add(new Employee(2, "janley", 18, "male", 50000));
        employees.add(new Employee(3, "barbie", 20, "female", 2000));
        employees.add(new Employee(4, "edgar", 20, "male", 20));
        employees.add(new Employee(5, "montemayor", 22, "male", 300));
        employees.add(new Employee(6, "naix", 20, "female", 100));
        employees.add(new Employee(7, "charing", 20, "female", 2000));
        given(employeeRepository.getEmployees()).willReturn(employees);

        // When
        List<Employee> actualEmployees = employeeService.getEmployees();

        // Then
        assertEquals(employees, actualEmployees);
        assertIterableEquals(employees, actualEmployees);

    }

    @Test
    void should_return_correct_employee_when_findEmployeeById_given_an_employee_id_5(){
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "russel", 22, "male", 1000));
        employees.add(new Employee(2, "janley", 18, "male", 50000));
        employees.add(new Employee(3, "barbie", 20, "female", 2000));
        employees.add(new Employee(4, "edgar", 20, "male", 20));
        employees.add(new Employee(5, "montemayor", 22, "male", 300));
        employees.add(new Employee(6, "naix", 20, "female", 100));
        employees.add(new Employee(7, "charing", 20, "female", 2000));
        given(employeeRepository.getEmployees()).willReturn(employees);

        // When
        Employee correctEmployee = employeeService.findEmployeeById(5);


        //then
        assertEquals( employees.get(4), correctEmployee);
    }

    @Test
    void should_return_employees_with_male_gender_when_findEmployeeByGender_given_employees_and_employee_gender_male(){
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "russel", 22, "male", 1000));
        employees.add(new Employee(2, "janley", 18, "male", 50000));
        employees.add(new Employee(4, "edgar", 20, "male", 20));
        employees.add(new Employee(5, "montemayor", 22, "male", 300));
        given(employeeRepository.getEmployees()).willReturn(employees);

        //when
        List<Employee> maleEmployees = employeeService.findEmployeeByGender("male");

        //then
        assertEquals(employees, maleEmployees);
    }

    @Test
    void should_return_correct_list_of_employees_by_pagination_when_getEmployeesByPagination_given_employees_page_index_and_page_size(){
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(6, "naix", 20, "female", 100));
        employees.add(new Employee(7, "charing", 20, "female", 2000));
        given(employeeRepository.getEmployees()).willReturn(employees);

        // When
        List<Employee> pageinationEmployees = employeeService.getEmployeesByPagination(1,5);


        //then
        assertIterableEquals(employees, pageinationEmployees);
    }




}
