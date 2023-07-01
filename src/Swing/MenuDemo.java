package Swing;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuDemo extends JFrame {
    private final Color colorValues[]=
            {Color.BLACK,Color.BLUE,Color.RED,Color.GREEN};
    private JRadioButtonMenuItem colorItems[],fonts[];//单选菜单项
    private JCheckBoxMenuItem styleItem[];//复选菜单项
    private  JLabel displayLabel;
    private ButtonGroup fontGroup,colorGroup;//按钮组
    private int style;
    public MenuDemo(String title){
        super(title);
        JMenuBar menuBar=new JMenuBar();//菜单栏
//File菜单
        JMenu fileMenu=new JMenu("File");//菜单
        fileMenu.setMnemonic('F');//设置快捷键
        JMenuItem aboutItem=new JMenuItem("About...");//菜单项
        fileMenu.add(aboutItem);
        aboutItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹窗
                JOptionPane.showMessageDialog(MenuDemo.this,
                        "本例子用于演示菜单的用法",
                        "About",JOptionPane.PLAIN_MESSAGE);
            }
        });
        JMenuItem exitItem=new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//Format菜单
        JMenu formatMenu=new JMenu("Format");
        //Color菜单
        String colors[]={"Black","Blue","Red","Green"};
        JMenu colorMenu=new JMenu("Color");
        colorItems=new JRadioButtonMenuItem[colors.length];
        colorGroup=new ButtonGroup();
        ItemHandler itemHandler=new ItemHandler();
        for(int i=0;i<colors.length;i++){
            colorItems[i]=new JRadioButtonMenuItem(colors[i]);
            colorMenu.add(colorItems[i]);
            colorGroup.add(colorItems[i]);
            colorItems[i].addActionListener(itemHandler);
        }
        colorItems[0].setSelected(true);

        //Font菜单
        String fontNames[]={"Serif","Monospaced","SansSerif"};
        JMenu fontMenu=new JMenu("Font");
        fonts=new JRadioButtonMenuItem[fontNames.length];
        fontGroup=new ButtonGroup();
        for(int i=0;i<fontNames.length;i++){
            fonts[i]=new JRadioButtonMenuItem(fontNames[i]);
            fontMenu.add(fonts[i]);
            fontGroup.add(fonts[i]);
            fonts[i].addActionListener(itemHandler);
        }
        fonts[0].setSelected(true);
        fontMenu.addSeparator();
        String styleNames[]={"Bold","Italic"};
        styleItem=new JCheckBoxMenuItem[styleNames.length];
        StyleHandler styleHandler=new StyleHandler();
        for(int i=0;i<styleNames.length;i++){
            styleItem[i]=new JCheckBoxMenuItem(styleNames[i]);
            fontMenu.add(styleItem[i]);
            styleItem[i].addItemListener(styleHandler);
        }

        formatMenu.add(colorMenu);
        formatMenu.addSeparator();//分割线
        formatMenu.add(fontMenu);
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);
        displayLabel=new JLabel("Hello World",SwingConstants.CENTER);
        displayLabel.setForeground(colorValues[0]);
        displayLabel.setFont(new Font("Serif",Font.PLAIN,72));
        this.setBackground(Color.WHITE);
        this.add(displayLabel,BorderLayout.CENTER);
        this.setJMenuBar(menuBar);
        this.setSize(600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    private class ItemHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //处理颜色
            for(int i=0;i<colorItems.length;i++){
                if(colorItems[i].isSelected()) {
                    displayLabel.setForeground(colorValues[i]);
                    break;
                }
            }
            //处理字体
            for(int i=0;i<fonts.length;i++){
                if(e.getSource()==fonts[i]) {
                    displayLabel.setFont(new Font(fonts[i].getText(), style, 72));
                    break;
                }
            }
            repaint();//重绘此组件
        }
    }
    /* 处理复选菜单项的事件 */
    private class StyleHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e) {
            style=0;
            if(styleItem[0].isSelected()) style+=Font.BOLD;
            if(styleItem[1].isSelected()) style+=Font.ITALIC;
            displayLabel.setFont(new Font(displayLabel.getFont().getName(),style,72));
            repaint();
        }
    }
    public static void main(String[] args) {
        new MenuDemo("hello");
    }

}
