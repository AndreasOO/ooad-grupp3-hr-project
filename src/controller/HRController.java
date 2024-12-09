package controller;

import Model.HRModel;
import View.HRView;

import javax.swing.*;

public class HRController {

    private HRView view;
    private HRModel model;

    public HRController(HRModel model) {
        this.model = model;
        view = new HRView(model);
        view.init();
        addActionListeners();
    }

    public void addActionListeners(){
        view.getSearchField().addActionListener(e->{
            view.clearTable();
            String searchTerm = view.getSearchField().getText();
            if (view.getRadioButtonName().isSelected()){
                model.setSearchResultByName(searchTerm);
            }
            else if (view.getRadioButtonEmail().isSelected()){
                model.setSearchResultByEmail(searchTerm);
            }
            else if (view.getRadioButtonPhone().isSelected()){
                model.setSearchResultByPhone(searchTerm);
            }
            else if (view.getRadioButtonID().isSelected()) {
                try{
                    model.setSearchResultById(Long.parseLong(searchTerm));
                } catch (NumberFormatException ex) {
                    System.out.println("Exception caught, program continues");
                }
            }
        });

        view.getShowDetailsButton().addActionListener(e->{
            int selectedRow = view.getSearchResultTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Select an employee to view details");
                return;
            }
            long id = Long.parseLong(view.getSearchResultTable().getValueAt(selectedRow, 0).toString());
            model.selectEmployee(id);
            view.updateEmployeeDetails();
        });

    }


}
