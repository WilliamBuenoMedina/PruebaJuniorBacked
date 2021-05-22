package CustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= NumericConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Numeric {

    public String message() default "El elemento no se puede convertir a numero";

    //Define grupos de restricciones relacionadas
    public Class<?>[] groups() default {};

    //Define detalles adicionales
    public Class <? extends Payload>[] payload() default {};



}
