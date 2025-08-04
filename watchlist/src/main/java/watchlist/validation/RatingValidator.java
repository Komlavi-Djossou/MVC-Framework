package watchlist.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingValidator implements ConstraintValidator<Rating, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        double number;
        try {
            number = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return number <= 10 && number >= 1;
    }
}