import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TextPredictorTest {
    private TextPredictor predictor;
    
    @Before
    public void setUp() {
        predictor = new TextPredictor();
    }

    @Test
    public void testEmptyInput() {
        List<String> results = predictor.getSuggestions("");
        assertTrue("Empty input should return empty list", results.isEmpty());
    }

    @Test
    public void testStartsWithP() {
        List<String> results = predictor.getSuggestions("p");
        assertEquals("Should return 4 results", 4, results.size());
        assertEquals("First word should be Pandora", "Pandora", results.get(0));
        assertEquals("Second word should be Paypal", "Paypal", results.get(1));
        assertEquals("Third word should be Pg&e", "Pg&e", results.get(2));
        assertEquals("Fourth word should be Phone", "Phone", results.get(3));
    }

    @Test
    public void testCaseInsensitive() {
        List<String> lowerCase = new ArrayList<>(predictor.getSuggestions("pro"));
        List<String> upperCase = new ArrayList<>(predictor.getSuggestions("PRO"));
        assertEquals("Case should not affect results", lowerCase, upperCase);
    }

    @Test
    public void testSpecialCharacters() {
        List<String> results = predictor.getSuggestions("pg&");
        assertTrue("Should find Pg&e", results.contains("Pg&e"));
    }

    @Test
    public void testNoMatches() {
        List<String> results = predictor.getSuggestions("xyz");
        assertTrue("Non-existing prefix should return empty list", results.isEmpty());
    }

    @Test
    public void testMaxFourResults() {
        List<String> results = predictor.getSuggestions("p");
        assertTrue("Should not return more than 4 results", results.size() <= 4);
    }

    @Test
    public void testSpaceInWord() {
        List<String> results = predictor.getSuggestions("project f");
        assertTrue("Should find words with spaces", results.contains("Project free tv"));
    }
}