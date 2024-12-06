import Model.HRModel;
import View.HRView;
import controller.HRController;

public class Main {
    public static void main(String[] args) {
        HRModel model = new HRModel();
        HRController controller = new HRController(model);
    }
}