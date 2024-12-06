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
            System.out.println("We made it here!?");
            String searchTerm = view.getSearchField().getText();
            if (searchTerm.isEmpty()){
                JOptionPane.showMessageDialog(null, "Cannot leave text field empty.");
                return;
            }
            if (view.getRadioButtonName().isSelected()){
                model.setSearchResultByName(searchTerm);
            } else if (view.getRadioButtonID().isSelected()) {
                model.setSearchResultById(Long.parseLong(searchTerm));
            }
        });

    }


}
