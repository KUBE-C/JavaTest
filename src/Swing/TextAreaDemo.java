package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TextAreaDemo extends JFrame {
    JTextArea area1=new JTextArea(5,10);
    JTextArea area2=new JTextArea(5,10);
    //在垂直方向总是显示滚动条，在水平方向只有当需要时候才显示滚动条
    JScrollPane pane1=new JScrollPane(area1,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    //panel2按默认方式创建，在垂直和水平都只有需要时才显示出滚动条
    JScrollPane pane2=new JScrollPane(area2);
    JButton button=new JButton("Copy");
    public TextAreaDemo(String title){
        super(title);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area2.setText(area1.getText());
            }
        });
        setLayout(new FlowLayout());//设置窗口布局为网格布局
        add(pane1);
        add(button);
        add(pane2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextAreaDemo("TextArea");
    }
}
