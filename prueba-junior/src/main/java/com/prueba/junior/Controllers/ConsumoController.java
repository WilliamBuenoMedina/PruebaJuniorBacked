package com.prueba.junior.Controllers;

import com.prueba.junior.Errors.ValidationError;
import com.prueba.junior.Form.SearchForm;
import com.prueba.junior.Models.Employee;
import com.prueba.junior.Services.ConsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class ConsumoController {

    @Autowired
    private ConsumoService consumoService;

    @PostMapping("/pruebaConsumo")
    public ResponseEntity index(@RequestBody @Valid SearchForm searchForm, BindingResult validador){
        if(validador.hasErrors()){
           List<ObjectError> errores = validador.getAllErrors();
           ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST,errores);
           return new ResponseEntity(validationError, HttpStatus.BAD_REQUEST);
        }
        String id = searchForm.getId();

        if (id.isEmpty()){
            return new ResponseEntity(consumoService.getEmployeeList(), HttpStatus.OK);
        }
        else{
            Employee resultado = consumoService.getEmployee(Integer.parseInt(id));
            if(resultado != null){
                return new ResponseEntity(resultado, HttpStatus.OK);
            }
            else{
                return new ResponseEntity("No se ha encontrado ningun empleado", HttpStatus.NOT_FOUND);
            }
        }
    }
}
