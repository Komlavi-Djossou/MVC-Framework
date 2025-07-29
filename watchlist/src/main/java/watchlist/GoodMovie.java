package watchlist;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.RetentionPolicy;

@Target ({ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy= GoodMovieValidator.class)
public @interface GoodMovie {

    String message() default "1) If rating ≥ 8, priority should be M/H. 2) If rating < 6, comment must be ≥15 chars.";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}