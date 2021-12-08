package testOnline.annotation;


import testOnline.entity.enumeration.AutorizeFilterTypes;
import testOnline.entity.enumeration.UserRole;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Target( {ElementType.METHOD, ElementType.TYPE} )
@Retention( RetentionPolicy.RUNTIME)
public @interface AutorizeFilter {
    AutorizeFilterTypes vType() default AutorizeFilterTypes.AUTORIZED;
    UserRole[] role() default {};
}
