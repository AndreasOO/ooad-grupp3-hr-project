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
            String searchTerm = view.getSearchField().getText();
            if (view.getRadioButtonName().isSelected()){
                model.setSearchResultByName(searchTerm);
            } else if (view.getRadioButtonID().isSelected()) {
                model.setSearchResultById(Long.parseLong(searchTerm));
            }
        });

    }


}
