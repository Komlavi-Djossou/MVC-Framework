package watchlist;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller class responsible for handling HTTP requests
 * related to the movie watchlist feature.
 */
@Controller
public class WatchlistController {

    // In-memory storage of WatchlistItem objects
    List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();

    // Static counter for assigning unique IDs to new WatchlistItems
    private static int index = 1;

    /**
     * Handles GET requests for the watchlist item form.
     * If an ID is provided, the form is pre-filled for editing.
     * Otherwise, a blank form is displayed for adding a new item.
     *
     * @param id Optional item ID for editing
     * @return ModelAndView object linking to the form view and its data
     */
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id) {

        String viewName = "watchlistItemForm";
        Map<String, Object> model = new HashMap<>();

        WatchlistItem watchlistItem = findWatchlistItemById(id);
        if (watchlistItem == null) {
            model.put("watchlistItem", new WatchlistItem()); // New blank item
        } else {
            model.put("watchlistItem", watchlistItem); // Editing existing item
        }

        return new ModelAndView(viewName, model);
    }

    /**
     * Searches for a WatchlistItem by ID within the current list.
     *
     * @param id The unique identifier to search for
     * @return The matching WatchlistItem, or null if not found
     */
    private WatchlistItem findWatchlistItemById(Integer id) {
        for (WatchlistItem watchlistItem : watchlistItems) {
            if (watchlistItem.getId().equals(id)) {
                return watchlistItem;
            }
        }
        return null;
    }

    /**
     * Handles POST requests submitted from the watchlist item form.
     * Adds a new item to the list and redirects to the watchlist view.
     *
     * @param watchlistItem The item submitted from the form
     * @return Redirect to the main watchlist page
     */
    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("watchlistItemForm");
        }

        WatchlistItem existingItem = findWatchlistItemById(watchlistItem.getId());

        if (existingItem == null) {
            watchlistItem.setId(index++);
            watchlistItems.add(watchlistItem);
        } else {
            existingItem.setComment(watchlistItem.getComment());
            existingItem.setPriority(watchlistItem.getPriority());
            existingItem.setRating(watchlistItem.getRating());
            existingItem.setTitle(watchlistItem.getTitle());
        }

        RedirectView redirect = new RedirectView();
        redirect.setUrl("/watchlist");

        return new ModelAndView(redirect);
    }

    /**
     * Displays the main watchlist view with all stored items.
     *
     * @return ModelAndView object containing the list of items and count
     */
    @GetMapping("/watchlist")
    public ModelAndView getWatchlist() {

        String viewName = "watchlist";
        Map<String, Object> model = new HashMap<>();
        model.put("watchlistItems", watchlistItems); // List of movies
        model.put("numberOfMovies", watchlistItems.size()); // Count

        return new ModelAndView(viewName, model);
    }
}
