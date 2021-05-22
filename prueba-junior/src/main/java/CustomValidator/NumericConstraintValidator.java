package CustomValidator;

import org.apache.commons.lang3.math.NumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumericConstraintValidator implements ConstraintValidator<Numeric, String> {


    @Override
    public  void initialize(Numeric constraintAnnotation){

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        boolean resultado = false;
        if(NumberUtils.isParsable(s)){
            resultado = true;
        }
        else if(s.isEmpty()){
            resultado = true;
        }
        return  resultado;
    }


}
