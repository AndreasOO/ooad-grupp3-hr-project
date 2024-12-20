package View;

import Database.Employee;
import Database.Position;
import Model.HRModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HRView implements EmployeeDetailsObserver, SearchResultObserver, FilterPositionObserver {

    JFrame frame;
    JPanel mainPanel;

    JPanel topPanel;
    JLabel searchLabel;
    JTextField searchField;
    JPanel radioButtonPanel;
    ButtonGroup buttonGroup;
    JRadioButton radioButtonName;
    JRadioButton radioButtonID;
    JRadioButton radioButtonEmail;
    JRadioButton radioButtonPhone;
    JLabel filterLabel;
    JComboBox<String> filterComboBox;

    JPanel centerPanel;
    JPanel searchResultPanel;
    JTable searchResultTable;
    DefaultTableModel searchResultTableModel;
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

    HRModel model;

    public HRView(HRModel model) {
        this.model = model;
        registerAsObserver();

        frame = new JFrame();
        mainPanel = new JPanel();

        topPanel = new JPanel();
        searchLabel = new JLabel("Search  ", SwingConstants.RIGHT);
        searchField = new JTextField();
        radioButtonPanel = new JPanel();
        buttonGroup  = new ButtonGroup();
        radioButtonName = new JRadioButton("Name");
        radioButtonID = new JRadioButton("ID");
        radioButtonEmail = new JRadioButton("Email");
        radioButtonPhone = new JRadioButton("Phone");
        filterLabel = new JLabel("Filter      ", SwingConstants.RIGHT);
        fillComboBox();

        centerPanel = new JPanel();
        searchResultPanel = new JPanel();
        searchResultTableModel = new DefaultTableModel();
        searchResultTable = new JTable(searchResultTableModel);
        searchResultTableModel.addColumn("ID");
        searchResultTableModel.addColumn("Name");
        searchResultTableModel.addColumn("Position");


        searchResultScrollPane = new JScrollPane(searchResultTable);
        showDetailsMainPanel = new JPanel();
        showDetailsTopPanel = new JPanel();
        showDetailsButton = new JButton("Show Details");
        showDetailsCenterPanel = new JPanel();
        showDetailsNameTextField = new JTextField();
        showDetailsEmploymentPercentageTextField = new JTextField();
        showDetailsPositionTextField = new JTextField();
        showDetailsEmailTextField = new JTextField();
        showDetailsSalaryTextField = new JTextField();
        showDetailsPhoneTextField = new JTextField();
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
        buttonGroup.add(radioButtonEmail);
        buttonGroup.add(radioButtonPhone);
        radioButtonPanel.setLayout(new GridLayout(2, 2));
        radioButtonPanel.add(radioButtonName);
        radioButtonPanel.add(radioButtonID);
        radioButtonPanel.add(radioButtonEmail);
        radioButtonPanel.add(radioButtonPhone);

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
        populateAllEmployees();
        frame.repaint();
        frame.revalidate();
    }

    private void fillComboBox() {
        int positionsLength = Position.values().length + 1;
        String[] positionNames = new String[positionsLength];
        positionNames[0] = "None";
        int counter = 1;
        for (Position position : Position.values()) {
            positionNames[counter] = (position.getPosition());
            counter++;
        }
        filterComboBox = new JComboBox<>(positionNames);
    }

    private void addEmployeeRow(Employee employee) {
        searchResultTableModel.addRow(new String[]{String.valueOf(employee.getEmployeeId()), employee.getName(), employee.getPosition().getPosition()});
    }

    private void registerAsObserver(){
        model.registerDetailsObserver(this);
        model.registerSearchObserver(this);
        model.registerPositionSearchObserver(this);
    }

    private void populateAllEmployees() {
        model.setSearchResultByName("");
    }

    private void fillFieldsWithDetails(Employee employee){
        showDetailsNameTextField.setText(employee.getName());
        showDetailsEmploymentPercentageTextField.setText(String.valueOf(employee.getWorkingPercentage()));
        showDetailsPositionTextField.setText(employee.getPosition().name());
        showDetailsEmailTextField.setText(employee.getEmail());
        showDetailsSalaryTextField.setText(String.valueOf(employee.getSalary()));
        showDetailsPhoneTextField.setText(employee.getPhoneNumber());
    }

    @Override
    public void updateEmployeeDetails() {
        Employee employee = model.getSelectedEmployee();
        fillFieldsWithDetails(employee);
    }

    @Override
    public void updateSearchResult() {
        List<Employee> getCurrentSearchResult = model.getCurrentSearchResult();
        for(Employee employee:getCurrentSearchResult){
            addEmployeeRow(employee);
        }
    }

    @Override
    public void updateFilterSearch() {
        clearTable();
        List<Employee> getFilteredResult = model.getCurrentFilteredSearch();
        for (Employee employee:getFilteredResult){
            addEmployeeRow(employee);
        }
    }

    public void clearTable() {
        searchResultTableModel.setRowCount(0);
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JRadioButton getRadioButtonName() {
        return radioButtonName;
    }

    public JRadioButton getRadioButtonID() {
        return radioButtonID;
    }


    public JRadioButton getRadioButtonEmail() {
        return radioButtonEmail;
    }

    public JRadioButton getRadioButtonPhone() {
        return radioButtonPhone;
    }

    public JButton getShowDetailsButton() {
        return showDetailsButton;
    }

    public JTable getSearchResultTable() {
        return searchResultTable;
    }

    public DefaultTableModel getSearchResultTableModel() {
        return searchResultTableModel;
    }

    public JComboBox<String> getFilterComboBox() {
        return filterComboBox;
    }
}
