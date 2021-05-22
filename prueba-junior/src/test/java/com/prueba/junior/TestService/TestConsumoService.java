package com.prueba.junior.TestService;

import com.prueba.junior.Form.SearchForm;
import com.prueba.junior.Models.Employee;
import com.prueba.junior.Repository.EmployeeRepository;
import com.prueba.junior.Services.ConsumoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestConsumoService {

    @InjectMocks
    private ConsumoService service;

    @Mock
    private EmployeeRepository repository;

    private static final Integer ID = 1;
    private static final String NAME = "Andrea";
    private static final String CONTRACT_TYPE = Employee.CONTRACT_HOURLY;
    private static final Integer ROLE_ID = 1;
    private static final String ROLE_NAME = "Administrator";
    private static final String ROLE_DESCRIPTION = null;
    private static final Integer HOURLY_SALARY= 10000;
    private static final Integer ANNUAL_SALARY= 14400000;

    @Before
    public void initialize(){
    }

    private List<Employee> getEmployeeList(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(ID);
        employee.setName(NAME);
        employee.setContractTypeName(CONTRACT_TYPE);
        employee.setRoleId(ROLE_ID);
        employee.setRoleName(ROLE_NAME);
        employee.setRoleDescription(ROLE_DESCRIPTION);
        employee.setHourlySalary(HOURLY_SALARY);
        employees.add(employee);
        return employees;
    }

    @Test
    public void getEmployee() throws Exception {
        Mockito.when(repository.getEmployees()).thenReturn(this.getEmployeeList());
        service.loadEmployees();
        Employee resultado = service.getEmployee(ID);
        assertTrue(resultado.getId()==ID);
        assertEquals(resultado.getName(), NAME);
        assertEquals(resultado.getContractTypeName(), CONTRACT_TYPE);
        assertTrue(resultado.getRoleId() == ROLE_ID);
        assertEquals(resultado.getRoleDescription(), ROLE_DESCRIPTION);
        assertEquals(resultado.getRoleName(), ROLE_NAME);
        assertTrue(resultado.getHourlySalary() == HOURLY_SALARY);
        assertTrue(resultado.getAnnualSalary() == ANNUAL_SALARY);
    }

    @Test
    public void getEmployees() throws Exception {
        Mockito.when(repository.getEmployees()).thenReturn(this.getEmployeeList());
        service.loadEmployees();
        List<Employee> resultado = service.getEmployeeList();
        assertEquals(resultado, repository.getEmployees());
    }
}
