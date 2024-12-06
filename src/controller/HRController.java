package controller;

import Model.HRModel;
import View.HRView;

public class HRController {

    private HRView view;
    private HRModel model;

    public HRController(HRModel model) {
        view = new HRView(model);
        view.init();
    }


}
