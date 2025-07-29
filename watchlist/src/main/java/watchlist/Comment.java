package watchlist;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE) // Changed from FIELD to TYPE
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommentValidator.class)
public @interface Comment {
    String message() default "Comment must be at least 15 characters for movies rated below 6";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}