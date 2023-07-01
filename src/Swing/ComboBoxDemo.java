package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxDemo extends JFrame {
    JComboBox<String> comboBox=new JComboBox<>();
    JButton button=new JButton("添加城市");
    JTextField textField=new JTextField(20);
    public ComboBoxDemo(String title){
        super(title);
       comboBox.addItem("长沙");
       comboBox.addItem("深圳");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=textField.getText();
                int sum=comboBox.getItemCount();
               for(int i=0;i<sum;i++){
                   String current=comboBox.getItemAt(i);
                   if(input.equals(current)){
                       textField.setText("添加"+input+"失败。不在可选范围内");
                       break;
                   }else if(i==sum-1&&input.equals(current)==false){
                       comboBox.addItem(input);
                       textField.setText("添加"+input+"成功");
                   }
               }
            }
        });

        setLayout(new FlowLayout());
       add(comboBox);
       add(button);
       add(textField);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       pack();
       setVisible(true);

    }
    public static void main(String[] args) {
        new ComboBoxDemo("ComboBox");
    }
}
