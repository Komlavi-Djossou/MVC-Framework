package watchlist.repository;

import watchlist.domain.WatchlistItem;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepository {

    // In-memory storage of WatchlistItem objects
    List<WatchlistItem> watchlistItems = new ArrayList<WatchlistItem>();

    // Static counter for assigning unique IDs to new WatchlistItems
    private static int index = 1;

    public List<WatchlistItem> getList(){
        return watchlistItems;
    }

    public void addItem(WatchlistItem watchlistItem){
        watchlistItem.setId(index++);
        watchlistItems.add(watchlistItem);

    }

    public WatchlistItem findById(Integer id){
        for (WatchlistItem watchlistItem: watchlistItems) {
            if (watchlistItem.getId().equals(id)){
                return watchlistItem;
            }
        }
        return null;
    }

    public WatchlistItem findByTitle(String title) {
        for (WatchlistItem watchlistItem: watchlistItems) {
            if ( watchlistItem.getTitle().equals(title)){
                return watchlistItem;
            }
        }

        return null;
    }

}
