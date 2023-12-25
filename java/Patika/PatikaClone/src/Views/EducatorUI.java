package Views;

import Controllers.EducatorController;
import Helpers.Constant;
import Helpers.Helper;
import Models.Content;
import Models.Course;
import Models.Item;
import Models.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EducatorUI extends JFrame {
    private final User user;
    private final EducatorController educatorController;

    private JPanel wrapper;
    private JScrollPane scrl_content;
    private JTable tbl_content;
    private JPanel pnl_add_content;
    private JLabel lbl_course;
    private JComboBox cbx_course;
    private JLabel lbl_title;
    private JTextField txt_title;
    private JLabel lbl_description;
    private JLabel lbl_link;
    private JTextField txt_link;
    private JButton btn_add_content;
    private JTabbedPane tabs;
    private JPanel pnl_right;
    private JSplitPane pnl_left;
    private JPanel pnl_add_quiz;
    private JLabel lbl_question;
    private JTextField txt_question;
    private JLabel lbl_a;
    private JTextField txt_a;
    private JLabel lbl_b;
    private JTextField txt_b;
    private JLabel lbl_c;
    private JTextField txt_c;
    private JLabel lbl_d;
    private JTextField txt_d;
    private JLabel lbl_answer;
    private JTextArea txt_content;
    private JComboBox cbx_answer;
    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;

    public EducatorUI(User user, EducatorController educatorController){
        this.user = user;
        this.educatorController = educatorController;
        this.add(wrapper);
        this.setSize(1000,500);
        this.setLocation( Helper.getScreen(this.getSize()).get("x"),  Helper.getScreen(this.getSize()).get("y") - 50);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(Constant.TITLE);
        this.setVisible(true);

        // Kursları Listele
        this.cbx_course.removeAllItems();
        for(Course course : this.educatorController.getCourseList()){
            this.cbx_course.addItem(new Item(course.getId(), course.getName()));
        }

        // Ders Ekle
        btn_add_content.addActionListener(e -> {
            // Önce ders kaydını ekle ve eklenen dersin id sini al
            if(Helper.isFieldEmpty(this.txt_title) || Helper.isAreaEmpty(this.txt_content) || Helper.isFieldEmpty(this.txt_link)){
                Helper.showMessage("validate");
            }else{
                int addToContent = this.educatorController.addToContent(((Item)this.cbx_course.getSelectedItem()).getId(), this.txt_title.getText(), this.txt_content.getText(), this.txt_link.getText());
                // sonra soru eklenmişse bu id ye göre soruyu ekle
                if(addToContent > 0){
                    if(!Helper.isFieldEmpty(txt_question) && !Helper.isFieldEmpty(txt_a) && !Helper.isFieldEmpty(txt_b) && !Helper.isFieldEmpty(txt_c) && !Helper.isFieldEmpty(txt_d)){
                        boolean addToQuiz = this.educatorController.addToQuiz(addToContent, txt_question.getText(), txt_a.getText(), txt_b.getText(), txt_c.getText(), txt_d.getText(), cbx_answer.getSelectedItem().toString());
                    }
                    txt_title.setText(null);
                    txt_content.setText(null);
                    txt_link.setText(null);
                    txt_question.setText(null);
                    txt_a.setText(null);
                    txt_b.setText(null);
                    txt_c.setText(null);
                    txt_d.setText(null);
                    Helper.showMessage("success");
                }else{
                    Helper.showMessage("Ders Eklenemedi!");
                }
            }
        });

        // Ders Listesi
        this.mdl_content_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                // id değerine sahip alanı disable et
                if(column == 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_content_list = {"ID","Ders Adı","İçerik","Link"};
        this.mdl_content_list.setColumnIdentifiers(col_content_list);
        this.row_content_list = new Object[col_content_list.length];
        this.loadContentList();
        this.tbl_content.setModel(mdl_content_list);
        this.tbl_content.getColumnModel().getColumn(0).setMaxWidth(100);
        this.tbl_content.getTableHeader().setReorderingAllowed(false);

    }

    private void loadContentList(){
        DefaultTableModel clearModel = (DefaultTableModel) tbl_content.getModel();
        clearModel.setRowCount(0);
        int i = 0;
        for (Content content : this.educatorController.getContentList()) {
            i = 0;
            this.row_content_list[i++] = content.getId();
            this.row_content_list[i++] = content.getTitle();
            this.row_content_list[i++] = content.getContent();
            this.row_content_list[i++] = content.getLink();
            this.mdl_content_list.addRow(row_content_list);
        }
    }


}
