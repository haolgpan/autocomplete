import java.util.*;

public class TextPredictor {
    // List of words to search from
    private static final String[] WORDS = {
        "Pandora", "Pinterest", "Paypal", "Pg&e", "Project free tv", 
        "Priceline", "Press democrat", "Progressive", "Project runway",
        "Proactive", "Programming", "Progeria", "Progesterone", "Progenex", 
        "Procurable", "Processor", "Proud", "Print", "Prank",
        "Bowl", "Owl", "River", "Phone", "Kayak", "Stamps", "Reprobe"
    };
    
    /**
     * Returns up to 4 word suggestions that start with the given prefix
     * @param prefix The string to search for
     * @return List of matching words, sorted alphabetically
     */
    public List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        
        if (prefix == null || prefix.isEmpty()) {
            return suggestions;
        }

        // Search case-insensitive
        prefix = prefix.toLowerCase();
        for (String word : WORDS) {
            if (word.toLowerCase().startsWith(prefix)) {
                suggestions.add(word);
            }
        }
        
        Collections.sort(suggestions);
        return suggestions.size() <= 4 ? suggestions : suggestions.subList(0, 4);
    }
} 