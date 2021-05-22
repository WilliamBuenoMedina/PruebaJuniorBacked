package com.prueba.junior.Services;

import com.prueba.junior.Models.Employee;
import com.prueba.junior.Repository.EmployeeRepository;
import io.swagger.annotations.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConsumoService {

    private List<Employee> employeeList;

    @Autowired
    private EmployeeRepository repository;

    public ConsumoService() {
    }

    @PostConstruct
    public void loadEmployees(){
        try{
            employeeList = repository.getEmployees();
        }catch (Exception e){
            System.out.println(e.getMessage());
            employeeList = new ArrayList<>();
        }
    }

    public Employee getEmployee(int id){
        Employee resultado = employeeList.stream()
                .filter(employee -> (employee.getId() == id))
                .findFirst()
                .orElse(null);
        return resultado;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
