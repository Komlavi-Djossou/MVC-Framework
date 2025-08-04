package watchlist.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import watchlist.domain.WatchlistItem;

public class GoodMovieValidator implements ConstraintValidator<GoodMovie, WatchlistItem> {
    @Override
    public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {
        return !(Double.valueOf(value.getRating()) >= 8
                &&  "L".equals(value.getPriority()));
    }
}
