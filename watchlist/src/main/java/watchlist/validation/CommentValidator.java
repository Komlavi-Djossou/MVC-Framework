package watchlist.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import watchlist.domain.WatchlistItem;

public class CommentValidator implements ConstraintValidator<Comment, WatchlistItem> {

    @Override
    public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {
        if (value == null)
            return true; // don’t validate null item

        String ratingStr = value.getRating();
        String comment = value.getComment();

        if (ratingStr == null || ratingStr.isBlank())
            return true; // skip if rating not provided

        try {
            double rating = Double.parseDouble(ratingStr);

            // Only validate if rating is less than 6
            if (rating < 6) {
                return comment != null && comment.trim().length() >= 15;
            }

        } catch (NumberFormatException e) {
            // Allow form to show other validation errors for rating
            return true;
        }

        return true; // if rating is not < 6, validation passes
    }
}
