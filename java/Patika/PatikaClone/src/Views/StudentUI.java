package Views;

import Controllers.PatikaController;
import Controllers.StudentController;
import Helpers.Constant;
import Helpers.Helper;
import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentUI extends JFrame {
    private final User user;
    private final StudentController studentController;
    private final PatikaController patikaController;

    private JPanel wrapper;
    private JScrollPane scrl_content;
    private JScrollPane scrl_contents;
    private JPanel pnl_contents;
    private JComboBox cbx_patika;
    private JPanel pnl_content;
    private JTextPane txt_content;
    private JTable tbl_courses;
    private JLabel lbl_content_title;
    private JLabel lbl_content_link;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;

    public StudentUI(User user, StudentController studentController, PatikaController patikaController){
        this.user = user;
        this.studentController = studentController;
        this.patikaController = patikaController;

        this.add(wrapper);
        this.setSize(1000,500);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y") - 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
        this.setVisible(true);

        // Patikaları Listele
        this.cbx_patika.removeAllItems();
        for(Patika patika : this.patikaController.getPatikaList()){
            this.cbx_patika.addItem(new Item(patika.getId(), patika.getName()));
        }

        // Kurs tablo ayarı
        ArrayList<Course> courses = this.studentController.getCourseList(((Item)cbx_patika.getSelectedItem()).getId());
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
        Object[] col_course_list = {"ID","Kurs Adı"};
        this.mdl_course_list.setColumnIdentifiers(col_course_list);
        this.row_course_list = new Object[col_course_list.length];
        this.loadCourseList(((Item)cbx_patika.getSelectedItem()).getId());
        this.tbl_courses.setModel(mdl_course_list);
        this.tbl_courses.getColumnModel().getColumn(0).setMaxWidth(40);
        this.tbl_courses.getTableHeader().setReorderingAllowed(false);

        // Patika Seçilince patikaya ait kursları listele
        cbx_patika.addActionListener(e -> {
            //System.out.println(((Item)cbx_patika.getSelectedItem()).getName());
            this.loadCourseList(((Item)cbx_patika.getSelectedItem()).getId());
        });

        // Listeden Seçilen Kurs
        tbl_courses.getSelectionModel().addListSelectionListener(e -> {
            int selected_course_id = Integer.parseInt(tbl_courses.getValueAt(tbl_courses.getSelectedRow(), 0).toString());
            // selected_course_id ye göre contentleri dersleri getir
            Content content = this.studentController.getContent(selected_course_id);
            if(content != null){
                this.lbl_content_title.setText(content.getTitle());
                this.lbl_content_link.setText(content.getLink());
                Quiz quiz = this.studentController.getQuiz(content.getId());
                String contentCreate = content.getContent()+"\n\n";
                if(quiz != null){
                    contentCreate += quiz.getQuestion()+"\n";
                    contentCreate += "A) "+quiz.getA()+"\n";
                    contentCreate += "B) "+quiz.getB()+"\n";
                    contentCreate += "C) "+quiz.getC()+"\n";
                    contentCreate += "D) "+quiz.getD()+"\n";
                }
                this.txt_content.setText(contentCreate);
            }
        });
    }

    private void loadCourseList(int patikaId){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courses.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Course course : this.studentController.getCourseList(patikaId)) {
            i = 0;
            this.row_course_list[i++] = course.getId();
            this.row_course_list[i++] = course.getName();
            this.mdl_course_list.addRow(row_course_list);
        }
    }
}
