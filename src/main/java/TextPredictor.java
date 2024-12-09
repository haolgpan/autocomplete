import java.util.*;

public class TextPredictor {
    // Static array of words to search from - could be replaced with a database or file in a production environment
    private static final String[] WORDS = {
        "Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", 
        "Priceline", "Press democrat", "Progressive", "Project runway",
        "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", 
        "Procurable", "Processor", "Proud", "Print", "Prank",
        "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"
    };
    
    // Lowercase version of WORDS for efficient comparison
    private static final String[] WORDS_LOWERCASE = Arrays.stream(WORDS)
            .map(String::toLowerCase)
            .toArray(String[]::new);
    
    // Reuse the same list instance to avoid creating new objects on each method call
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
        
        // Return empty list for null or empty input
        if (prefix == null || prefix.isEmpty()) {
            return suggestions;
        }

        // Convert to lowercase once for case-insensitive comparison
        prefix = prefix.toLowerCase();
        
        // Collect all matching words using pre-computed lowercase versions
        for (int i = 0; i < WORDS.length; i++) {
            if (WORDS_LOWERCASE[i].startsWith(prefix)) {
                suggestions.add(WORDS[i]);
            }
        }
        
        // Sort all matches alphabetically before limiting to 4 items
        Collections.sort(suggestions);
        
        // Return either all matches (if 4 or fewer) or just the first 4
        return suggestions.size() <= 4 ? suggestions : suggestions.subList(0, 4);
    }
} 