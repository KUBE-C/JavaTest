package Swing;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo extends JFrame {
    private JButton b1 = new JButton("输入文本"),b2 = new JButton("拷贝");
    //三个文本框
    private JTextField
            t1 = new JTextField(30),
            t2 = new JTextField(30),
            t3 = new JTextField(30);
    private String str = new String();//存放用户当前选择的文本
    private UpperCaseDocument ucd = new UpperCaseDocument();
    //构造方法
    public TextFieldDemo(String title){
        super(title);
        //为两个Button注册事件监听器
        b1.addActionListener(new ActionListenerB1());
        b2.addActionListener(new ActionListenerB2());
        t1.setDocument(ucd);//使t1文本框和UpperCaseDocument对象ucd关联(相同)
        ucd.addDocumentListener(new DocumentListenerT());//为UpperCaseDocument对象ucd注册文档监听器
        setLayout(new GridLayout(4,1));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        add(buttonPanel);
        add(t1);
        add(t2);
        add(t3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    //主函数
    public static void main(String[] args) {
        new TextFieldDemo("Hello");
    }
    //两个按钮的监听事件
    class ActionListenerB1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setText("");
            t3.setText("");
            t1.setEditable(true);//按钮b1按钮，文本框t1是可编辑的
        }
    }
    class ActionListenerB2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (t1.getSelectedText()==null)//若选择文本的为空，则读取整个文本框的所有文本，否则只读取选择的
                str = t1.getText();//文本
            else
                str = t1.getSelectedText();//若选定为null。返回null

            ucd.setUpperCase(false);
            t1.setText("Inserted by Button2:"+str);//重新设置文本框内容
            ucd.setUpperCase(true);
            t1.setEditable(false);//文本框t1不是可编辑的
        }
    }
    //UpperCaseDocument对象ucd的监听器
    class DocumentListenerT implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent e) {//增加操作
            t2.setText(t1.getText());//显示与t1文本框一样得内容
            t3.setText("Text:"+t1.getText());
        }
        @Override
        public void removeUpdate(DocumentEvent e) {//删除操作
            t2.setText(t1.getText());
        }
        @Override
        public void changedUpdate(DocumentEvent e) {}//修改操作
    }
}
//关联
class UpperCaseDocument extends PlainDocument{  //可与文本框关联
    private boolean upperCase = true;
    public void setUpperCase(boolean flag){
        upperCase = flag;
    }
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException{   //覆盖了plainDocument的insertString方法
        if (upperCase) str = str.toUpperCase();//把用户输入的文本改成大写
        super.insertString(offset, str, a);//调用父类的insertString方法
    }
}

