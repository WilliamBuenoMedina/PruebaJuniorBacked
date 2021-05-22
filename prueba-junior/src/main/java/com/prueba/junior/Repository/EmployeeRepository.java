package com.prueba.junior.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.junior.Models.Employee;
import org.springframework.stereotype.Repository;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    public List<Employee> getEmployees () throws Exception{
        try {
            URL url = new URL("http://masglobaltestapi.azurewebsites.net/api/Employees");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            return this.mapEmployees(con) ;

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    private List<Employee> mapEmployees(HttpURLConnection con) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Employee> employees = mapper.readValue(con.getInputStream(),
                    new TypeReference<List<Employee>>() {});
            return  employees;

        }catch (Exception e){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readValue(con.getErrorStream(), JsonNode.class);
            String mensajeError= json.findPath("Message").textValue();
            throw  new Exception(mensajeError);
        }
    }
}
