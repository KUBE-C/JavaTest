package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class menu02 extends JFrame {
    private JPopupMenu popupMenu;
    public menu02() {
        super("弹出式菜单");
        //创建一个弹出式菜单
        popupMenu = new JPopupMenu();
        //创建菜单项
        JMenuItem createItem = new JMenuItem("create");
        JMenuItem exitItem = new JMenuItem("exit");
        //监听器
        exitItem.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //向JPopupMenu菜单添加菜单项
        popupMenu.add(createItem);
        popupMenu.addSeparator();//使得菜单项之间产生一个分割线
        popupMenu.add(exitItem);
        //向JFrame窗口添加clicked鼠标事件监听器
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //通过值匹配，当点击右键时，显示JPopupMenu菜单
           /*
               e.getButton()返回值分别为NOBUTTON、BUTTON1、BUTTON2、BUTTON3
                分别表示无点击、左击、中间键、右击
           */
                if(e.getButton()==e.BUTTON3){
                    popupMenu.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出系统
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);//居中
        this.setVisible(true);//可见
    }
    public static void main(String[] args) {
        new menu02();
    }
}
