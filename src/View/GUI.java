package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class GUI {
    JFrame frame;
    JPanel mainPanel;

    JPanel topPanel;
    JLabel searchLabel;
    JTextField searchField;
    JPanel radioButtonPanel;
    ButtonGroup buttonGroup;
    JRadioButton radioButtonName;
    JRadioButton radioButtonID;
    JLabel filterLabel;
    JComboBox<String> filterComboBox;

    JPanel centerPanel;
    JPanel searchResultPanel;
    JTable searchResultTable;
    JScrollPane searchResultScrollPane;

    JPanel showDetailsMainPanel;
    JPanel showDetailsTopPanel;
    JButton showDetailsButton;
    JPanel showDetailsCenterPanel;
    JTextField showDetailsNameTextField;
    JTextField showDetailsEmploymentPercentageTextField;
    JTextField showDetailsPositionTextField;
    JTextField showDetailsEmailTextField;
    JTextField showDetailsSalaryTextField;
    JTextField showDetailsPhoneTextField;


    public GUI() {
        frame = new JFrame();
        mainPanel = new JPanel();

        topPanel = new JPanel();
        searchLabel = new JLabel("Search  ", SwingConstants.RIGHT);
        searchField = new JTextField();
        radioButtonPanel = new JPanel();
        buttonGroup  = new ButtonGroup();
        radioButtonName = new JRadioButton("Name");
        radioButtonID = new JRadioButton("ID");
        filterLabel = new JLabel("Filter      ", SwingConstants.RIGHT);
        filterComboBox = new JComboBox<>(new String[]{"None", "Developer", "Manager", "HR"});

        centerPanel = new JPanel();
        searchResultPanel = new JPanel();
        searchResultTable = new JTable(new String[][]{new String[]{"1", "Jane Doe", "Manager"}},new String[]{"ID", "Name", "Position"});
        searchResultScrollPane = new JScrollPane(searchResultTable);
        showDetailsMainPanel = new JPanel();
        showDetailsTopPanel = new JPanel();
        showDetailsButton = new JButton("Show Details");
        showDetailsCenterPanel = new JPanel();
        showDetailsNameTextField = new JTextField("Jane Doe");
        showDetailsEmploymentPercentageTextField = new JTextField("100%");
        showDetailsPositionTextField = new JTextField("Manager");
        showDetailsEmailTextField = new JTextField("jane@doe.com");
        showDetailsSalaryTextField = new JTextField("53 000");
        showDetailsPhoneTextField = new JTextField("09-12 55 12");
    }

    public void init() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);


        radioButtonName.setSelected(true);
        buttonGroup.add(radioButtonName);
        buttonGroup.add(radioButtonID);
        radioButtonPanel.setLayout(new GridLayout(2, 1));
        radioButtonPanel.add(radioButtonName);
        radioButtonPanel.add(radioButtonID);

        topPanel.setLayout(new GridLayout(1,5));
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(radioButtonPanel);
        topPanel.add(filterLabel);
        topPanel.add(filterComboBox);

        centerPanel.setLayout(new GridLayout(2,1));
        centerPanel.add(searchResultPanel);
        centerPanel.add(showDetailsMainPanel);

        searchResultPanel.setLayout(new GridLayout(1,1));
        searchResultPanel.add(searchResultScrollPane);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        searchResultTable.setDefaultRenderer(Object.class, centerRenderer);


        showDetailsMainPanel.setLayout(new BorderLayout());
        showDetailsMainPanel.add(showDetailsTopPanel, BorderLayout.NORTH);
        showDetailsTopPanel.setLayout(new GridLayout(1,1));
        showDetailsTopPanel.add(showDetailsButton, BorderLayout.NORTH);

        showDetailsMainPanel.add(showDetailsCenterPanel);
        showDetailsCenterPanel.setLayout(new GridLayout(4,3));
        showDetailsCenterPanel.add(new JLabel("Name"));
        showDetailsCenterPanel.add(new JLabel("Employment Percentage"));
        showDetailsCenterPanel.add(new JLabel("Position"));
        showDetailsCenterPanel.add(showDetailsNameTextField);
        showDetailsCenterPanel.add(showDetailsEmploymentPercentageTextField);
        showDetailsCenterPanel.add(showDetailsPositionTextField);
        showDetailsCenterPanel.add(new JLabel("Email"));
        showDetailsCenterPanel.add(new JLabel("Salary"));
        showDetailsCenterPanel.add(new JLabel("Phone number"));
        showDetailsCenterPanel.add(showDetailsEmailTextField);
        showDetailsCenterPanel.add(showDetailsSalaryTextField);
        showDetailsCenterPanel.add(showDetailsPhoneTextField);


    }

}
