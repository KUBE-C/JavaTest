package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    private JButton button=new JButton("提交");
    private MyDialog dialog=new MyDialog(this);
    private JTextField textField=new JTextField(10);
    public DialogDemo(String title){
        super(title);
        textField.setEditable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setEditable(true);
                textField.setText(dialog.getTest());
            }
        });
        setLayout(new FlowLayout());
        add(textField);
        add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DialogDemo("hello");
    }

}
class MyDialog extends JDialog{
    private JLabel label=new JLabel("请输入姓名：");
    private JTextField textField=new JTextField(10);
    private JButton button=new JButton("OK");
    public MyDialog(JFrame parent){
        super(parent,"提示",true);
        setLayout(new FlowLayout());
        add(label);
        add(textField);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();;//销毁对话框（周四hi图形界面被销毁，dialog对象仍然存在）
            }
        });
        add(button);
        pack();
    }
    public String getTest(){
        return textField.getText();
    }
}
