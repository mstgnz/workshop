package Views;

import Controllers.PatikaController;
import Helpers.Constant;
import Helpers.Helper;
import Models.Patika;

import javax.swing.*;

public class UpdatePatikaUI extends JFrame {

    private final PatikaController patikaController;

    private JPanel wrapper;
    private JLabel lbl_patika_name;
    private JTextField txt_patika_name;
    private JButton btn_patika;
    private Patika patika;

    public UpdatePatikaUI(Patika patika, PatikaController patikaController){
        this.add(wrapper);
        this.setSize(350,200);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y"));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
        this.setVisible(true);
        this.patika = patika;
        this.patikaController = patikaController;

        txt_patika_name.setText(patika.getName());

        btn_patika.addActionListener(e -> {
            if(Helper.isFieldEmpty(txt_patika_name)){
                Helper.showMessage("validate");
            }else{
                boolean isUpdate = this.patikaController.updatePatika(patika.getId(), txt_patika_name.getText());
                if(isUpdate){
                    Helper.showMessage("success");
                }else{
                    Helper.showMessage("error");
                }
                this.dispose();
            }
        });
    }
}
