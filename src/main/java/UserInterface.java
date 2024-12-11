import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.List;

public class UserInterface extends JFrame {
    private JTextField inputField;
    private DefaultListModel<String> listModel;
    private final TextPredictor predictor;

    public UserInterface() {
        predictor = new TextPredictor();
        setupUI();
    }

    private void setupUI() {
        // Basic window setup
        setTitle("Autocomplete");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input panel with text field
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputField = new JTextField(20);
        inputPanel.add(new JLabel("Type here: "));
        inputPanel.add(inputField);

        // List to show suggestions
        listModel = new DefaultListModel<>();
        JList<String> suggestionList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(suggestionList);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Listen for text changes
        inputField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateSuggestions(); }
            public void removeUpdate(DocumentEvent e) { updateSuggestions(); }
            public void insertUpdate(DocumentEvent e) { updateSuggestions(); }
        });

        // Final window setup
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //Updates the suggestion list based on the input text
    private void updateSuggestions() {
        String input = inputField.getText();
        List<String> suggestions = predictor.getSuggestions(input);
        
        listModel.clear();
        for (String suggestion : suggestions) {
            listModel.addElement(suggestion);
        }
    }
} 