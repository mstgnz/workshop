package Views;

import Controllers.CourseController;
import Controllers.ModeratorController;
import Controllers.PatikaController;
import Helpers.Constant;
import Helpers.Helper;
import Models.Course;
import Models.Item;
import Models.Patika;
import Models.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class ModeratorUI extends JFrame {
    private final User user;
    private final ModeratorController moderatorController;
    private final PatikaController patikaController;
    private final CourseController courseController;

    private JPanel wrapper;
    private JTabbedPane tab_courses;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scrl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JLabel lbl_fullname;
    private JTextField txt_fullname;
    private JLabel lbl_email;
    private JTextField txt_email;
    private JLabel lbl_password;
    private JTextField txt_password;
    private JLabel lbl_type;
    private JComboBox cbx_type;
    private JButton btn_submit;
    private JTextField txt_user_id;
    private JButton btn_user_delete;
    private JLabel lbl_user;
    private JButton btn_search;
    private JPanel pnl_patika;
    private JScrollPane scrl_patika_list;
    private JTable tbl_patika_list;
    private JLabel lbl_patika;
    private JTextField txt_patika_name;
    private JButton btn_patika;
    private JScrollPane scrl_courses;
    private JTable tbl_courses;
    private JPanel pnl_courses;
    private JPanel pnl_course_add;
    private JTextField txt_course_name;
    private JLabel lbl_course_name;
    private JLabel lbl_course_lang;
    private JTextField txt_course_lang;
    private JLabel lbl_course_patika;
    private JComboBox cbx_course_patika;
    private JLabel lbl_course_educator;
    private JComboBox cbx_course_educator;
    private JButton btn_course_add;
    private JTextField txt_course_id;
    private JLabel lbl_course_id;
    private JButton btn_course_delete;
    // Patika
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    // Course
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    public ModeratorUI(User user, ModeratorController moderatorController, PatikaController patikaController, CourseController courseController){
        this.user = user;
        this.moderatorController = moderatorController;
        this.patikaController = patikaController;
        this.courseController = courseController;

        this.add(wrapper);
        this.setSize(1000,500);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y"));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
        this.setVisible(true);

        // Welcome Text
        this.lbl_welcome.setText(this.user.getFullName());

        // Logout Button
        btn_logout.addActionListener(e -> {
            this.dispose();
            //LoginUI loginUI = new LoginUI(new Query(), new LoginController(new Query()));
        });

        // Kullanıcılar Listesi
        this.userListTable();

        // Listeden Seçilen
        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selected_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                txt_user_id.setText(selected_user_id);
            }catch (Exception ignored){}
        });

        // Listeden güncelle
        tbl_user_list.getModel().addTableModelListener(e -> {
            System.out.println(e.getType());
            if(e.getType() == TableModelEvent.UPDATE){
                int userId = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String fullName = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String email = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String type = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                this.updateUser(userId, fullName, email, type);
            }
        });

        // Kullanıcı Ekle
        btn_submit.addActionListener(e -> {
            this.addUser();
        });

        // Kullanıcı Sİl
        btn_user_delete.addActionListener(e -> {
            this.deleteUser();
        });
        // Kullanıcı Ara
        btn_search.addActionListener(e -> {
            this.searchUser();
        });

        // PATIKA
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);
        updateMenu.addActionListener(e -> {
            String selectPatikaName = tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 1).toString();
            Patika patika = this.patikaController.getPatika(selectPatikaName);
            UpdatePatikaUI updatePatikaUI = new UpdatePatikaUI(patika, patikaController);
            updatePatikaUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPatikaList();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            if(Helper.confirm("sure")){
                String selectPatikaName = tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 1).toString();
                this.patikaController.deletePatika(selectPatikaName);
                this.loadPatikaList();
            }
        });

        // Patika Listesi
        mdl_patika_list = new DefaultTableModel();
        Object[] col_patika_list = {"ID","Patika Adı"};
        mdl_patika_list.setColumnIdentifiers(col_patika_list);
        row_patika_list = new Object[col_patika_list.length];
        this.loadPatikaList();
        // Popup Menu Settings
        tbl_patika_list.setComponentPopupMenu(patikaMenu);
        // touchpad ile sağ tıklama yapılınca hiç biri tetiklenmiyor.
        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println(e.getPoint());
                int selected_row = tbl_patika_list.rowAtPoint(e.getPoint());
                tbl_patika_list.setRowSelectionInterval(selected_row, selected_row);
            }
        });

        // Patika Ekle
        btn_patika.addActionListener(e -> {
            this.addPatika();
        });

        // Patika Listeden güncelle
        tbl_patika_list.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int patikaId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
                String name = tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 1).toString();
                this.patikaController.updatePatika(patikaId, name);
                this.loadPatikaList();
            }
        });

        // DERSLER
        this.mdl_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // id değerine sahip alanı disable et
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_course_list = {"ID","Ders Adı","Programlama Dili","Patika","Eğitmen"};
        this.mdl_course_list.setColumnIdentifiers(col_course_list);
        this.row_course_list = new Object[col_course_list.length];
        this.loadCourseList();
        this.tbl_courses.setModel(mdl_course_list);
        this.tbl_courses.getColumnModel().getColumn(0).setMaxWidth(100);
        this.tbl_courses.getTableHeader().setReorderingAllowed(false);

        // Ders Ekle
        btn_course_add.addActionListener(e -> {
            this.addCourse();
        });

        // Ders Listeden güncelle
        tbl_courses.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int courseId = Integer.parseInt(tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 0).toString());
                String name = tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 1).toString();
                String lang = tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 2).toString();
                this.courseController.updateCourse(courseId, name, lang);
                this.loadCourseList();
            }
        });

        // Listeden Seçilen Kurs
        tbl_courses.getSelectionModel().addListSelectionListener(e -> {
            try {
                String selected_course_id = tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 0).toString();
                txt_course_id.setText(selected_course_id);
            }catch (Exception ignored){}
        });

        // Ders Sil
        btn_course_delete.addActionListener(e -> {
            this.deleteCourse();
            this.loadCourseList();
        });
    }

    private void userListTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // id değerine sahip alanı disable et
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] tableTitle = {"Id", "Full Name", "Email", "Type"};
        defaultTableModel.setColumnIdentifiers(tableTitle);

        for (User user :this.moderatorController.getUserList()) {
            Object[] obj = new Object[tableTitle.length];
            obj[0] = user.getId();
            obj[1] = user.getFirstname()+" "+user.getLastname();
            obj[2] = user.getEmail();
            obj[3] = user.getType();
            defaultTableModel.addRow(obj);
        }

        this.loadCourseEducatorList();

        this.tbl_user_list.setModel(defaultTableModel);
        this.tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    private void addUser(){
        if(!Helper.isValidFullName(txt_fullname) || Helper.isFieldEmpty(txt_email) || Helper.isFieldEmpty(txt_password)){
            Helper.showMessage("validate");
        }else{
            User findUser = this.moderatorController.getUser(txt_email.getText());
            if(findUser == null){
                boolean isAddedUser = this.moderatorController.addUser(txt_fullname.getText(), txt_email.getText(), txt_password.getText(), Objects.requireNonNull(cbx_type.getSelectedItem()).toString());
                if(isAddedUser){
                    Helper.showMessage("success");
                    this.userListTable();
                    // clear input
                    txt_fullname.setText(null);
                    txt_email.setText(null);
                    txt_password.setText(null);
                }else{
                    Helper.showMessage("error");
                }
            }else{
                Helper.showMessage("duplicate");
            }
        }
    }

    private void deleteUser(){
        if(Helper.isFieldEmpty(txt_user_id)){
            Helper.showMessage("validate");
        }else{
            if(Helper.confirm("sure")){
                boolean isDeleteUser = this.moderatorController.deleteUser(Integer.parseInt(txt_user_id.getText()));
                txt_user_id.setText(null);
                if(isDeleteUser){
                    this.userListTable();
                    Helper.showMessage("Kullanıcı Silindi");
                }else{
                    Helper.showMessage("Hata! Kullanıcı Silinemedi");
                }
            }
        }
    }

    private void updateUser(int id, String fullName, String email, String type){
        User findUser = this.moderatorController.getUser(email);
        if(findUser == null || findUser.getEmail().equals(email)){
            boolean isUpdateUser = this.moderatorController.updateUser(id, fullName, email, type);
            if(isUpdateUser){
                this.userListTable();
                Helper.showMessage("Kullanıcı Güncellendi");
            }else{
                Helper.showMessage("Hata! Kullanıcı Güncellenemedi");
            }
        }else{
            Helper.showMessage("duplicate");
        }

    }

    private void searchUser() {
        ArrayList<User> users = this.moderatorController.searchUserList(txt_email.getText(), txt_fullname.getText(), cbx_type.getSelectedItem().toString());
        DefaultTableModel defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // id değerine sahip alanı disable et
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] tableTitle = {"Id", "Full Name", "Email", "Type"};
        defaultTableModel.setColumnIdentifiers(tableTitle);

        for (User user : users) {
            Object[] obj = new Object[tableTitle.length];
            obj[0] = user.getId();
            obj[1] = user.getFirstname()+" "+user.getLastname();
            obj[2] = user.getEmail();
            obj[3] = user.getType();
            defaultTableModel.addRow(obj);
        }

        this.tbl_user_list.setModel(defaultTableModel);
        this.tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    private void loadPatikaList(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_patika_list.getModel();
        clearModel.setRowCount(0);
        for (Patika patika : this.patikaController.getPatikaList()) {
            this.row_patika_list[0] = patika.getId();
            this.row_patika_list[1] = patika.getName();
            this.mdl_patika_list.addRow(row_patika_list);
        }
        this.tbl_patika_list.setModel(mdl_patika_list);
        this.tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        this.tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(100);
        this.loadCourseList();
    }

    private void addPatika(){
        if(Helper.isFieldEmpty(txt_patika_name)){
            Helper.showMessage("validate");
        }else{
            Patika findPatika = this.patikaController.getPatika(txt_patika_name.getText());
            if(findPatika == null){
                boolean isAddedPatika = this.patikaController.addPatika(txt_patika_name.getText());
                if(isAddedPatika){
                    Helper.showMessage("success");
                    this.loadPatikaList();
                    // clear input
                    txt_patika_name.setText(null);
                }else{
                    Helper.showMessage("error");
                }
            }else{
                Helper.showMessage("duplicate");
            }
        }
    }

    private void loadCourseList(){
        this.loadCoursePatikaList();
        this.loadCourseEducatorList();

        DefaultTableModel clearModel = (DefaultTableModel) tbl_courses.getModel();
        clearModel.setRowCount(0);
        if(this.row_course_list != null){
            int i = 0;
            for (Course course : this.courseController.gerCourseList()) {
                i = 0;
                this.row_course_list[i++] = course.getId();
                this.row_course_list[i++] = course.getName();
                this.row_course_list[i++] = course.getLanguage();
                this.row_course_list[i++] = course.getPatika() != null ? course.getPatika().getName() : null;
                this.row_course_list[i++] = course.getUser() != null ? course.getUser().getFullName() : null;
                this.mdl_course_list.addRow(row_course_list);
            }
        }
    }

    private void loadCoursePatikaList(){
        cbx_course_patika.removeAllItems();
        for(Patika patika : this.patikaController.getPatikaList()){
            cbx_course_patika.addItem(new Item(patika.getId(), patika.getName()));
        }
    }

    private void loadCourseEducatorList(){
        cbx_course_educator.removeAllItems();
        for(User user : this.moderatorController.getUserList()){
            if(user.getType().equals("educator")){
                cbx_course_educator.addItem(new Item(user.getId(), user.getFullName()));
            }
        }
    }

    private void addCourse(){
        if(Helper.isFieldEmpty(txt_course_name) || Helper.isFieldEmpty(txt_course_lang)){
            Helper.showMessage("validate");
        }else{
            Course firdCourse = this.courseController.getCourse(txt_course_name.getText());
            if(firdCourse == null){
                boolean isAddedCourse = this.courseController.addCourse(txt_course_name.getText(), txt_course_lang.getText(), ((Item)cbx_course_patika.getSelectedItem()).getId(), ((Item)cbx_course_educator.getSelectedItem()).getId());
                if(isAddedCourse){
                    Helper.showMessage("success");
                    this.loadCourseList();
                    // clear input
                    txt_course_name.setText(null);
                    txt_course_lang.setText(null);
                }else{
                    Helper.showMessage("error");
                }
            }else{
                Helper.showMessage("duplicate");
            }
        }
    }

    private void deleteCourse(){
        if(Helper.isFieldEmpty(txt_course_id)){
            Helper.showMessage("validate");
        }else{
            if(Helper.confirm("sure")){
                boolean isDeleteCourse = this.courseController.deleteCourse(Integer.parseInt(txt_course_id.getText()));
                txt_course_id.setText(null);
                if(isDeleteCourse){
                    Helper.showMessage("Ders Silindi");
                }else{
                    Helper.showMessage("Hata! Ders Silinemedi");
                }
            }
        }
    }

    // Patika ve User silindiğinde onlara ait dersler otomatik olarak silinir. Bunun için bir kod yazılmadı. mysql foreign_key cascade delete olarak ayarlandı.
}
