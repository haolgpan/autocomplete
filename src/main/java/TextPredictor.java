import java.util.*;

/**
 * Provides word prediction functionality for the autocomplete feature.
 * Uses a sorted array of words to efficiently find and return suggestions
 * that match a given prefix.
 */
public class TextPredictor {
    // Static array of words to search from - could be replaced with a database or file in a production environment
    private static final String[] WORDS;
    private static final String[] WORDS_LOWERCASE;
    
    static {
        String[] keywords = {
            "Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", 
            "Priceline", "Press democrat", "Progressive", "Project runway",
            "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", 
            "Procurable", "Processor", "Proud", "Print", "Prank",
            "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"
        };

        Arrays.sort(keywords);
        WORDS = keywords;
        
        WORDS_LOWERCASE = Arrays.stream(WORDS)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }
    
    private final List<String> suggestions = new ArrayList<>();

    /**
     * Returns up to 4 word suggestions that start with the given prefix
     * @param prefix The string to search for
     * @return List of matching words, sorted alphabetically (limited to 4 items)
     * 
     * Note: Returns the same List object each time, cleared and repopulated
     * for efficiency. The caller should not store or modify the returned list.
     * Thread safety: This method is not thread-safe due to the reused list.
     */
    public List<String> getSuggestions(String prefix) {
        // Clear existing suggestions instead of creating a new list
        suggestions.clear();
        
        if (prefix == null || prefix.isEmpty()) {
            return suggestions;
        }

        prefix = prefix.toLowerCase();
        
        // Find first matching index using binary search
        int start = Arrays.binarySearch(WORDS_LOWERCASE, prefix);
        if (start < 0) {
            start = -(start + 1); // Convert insertion point if not found exactly
        }
        
        // Collect up to 4 matching words starting from found position
        for (int i = start; i < WORDS.length && suggestions.size() < 4; i++) {
            if (!WORDS_LOWERCASE[i].startsWith(prefix)) break;
            suggestions.add(WORDS[i]);
        }
        
        return suggestions;
    }
} 