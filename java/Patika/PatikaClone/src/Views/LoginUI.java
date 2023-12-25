package Views;

import Controllers.*;
import Helpers.Constant;
import Helpers.Helper;
import Helpers.Query;
import Models.User;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginUI extends JFrame{

    private final Query query;
    private final LoginController loginController;

    private JPanel wrapper;
    private JPanel pnl_logo;
    private JPanel pnl_login;
    private JLabel lbl_logo;
    private JLabel lbl_email;
    private JTextField txt_email;
    private JLabel lbl_password;
    private JTextField txt_password;
    private JButton btn_login;

    public LoginUI(Query query, LoginController loginController){
        this.query = query;
        this.loginController = loginController;
        this.add(wrapper);
        this.setSize(500,450);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y") - 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
        this.setVisible(true);
        this.setResizable(false);

        this.txt_password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btn_login.doClick();
                }
            }
        });

        // login
        btn_login.addActionListener(e -> {
           if(Helper.isFieldEmpty(txt_email) || Helper.isFieldEmpty(txt_password)){
               Helper.showMessage("validate");
           }else{
               User user = this.loginController.login(txt_email.getText(), txt_password.getText());
               if(user != null){
                   PatikaController patikaController = new PatikaController(this.query);
                   switch (user.getType()){
                       case "moderator": // Moderatör ise
                           ModeratorController moderatorController = new ModeratorController(user, this.query);
                           ModeratorUI moderatorUI = new ModeratorUI(user, moderatorController, patikaController, new CourseController(query, patikaController, moderatorController));
                           break;
                       case "educator": // Eğitmen ise
                           EducatorUI educatorUI = new EducatorUI(user, new EducatorController(user, this.query));
                           break;
                       default: // Öğrenci ise
                           StudentUI studentUI = new StudentUI(user, new StudentController(user, this.query), patikaController);
                           break;
                   }
                   this.dispose();
               }else{
                   Helper.showMessage("Kullanıcı adı veya paralo yanlış!");
               }
           }
        });
        txt_password.addKeyListener(new KeyAdapter() {
        });
    }

}
