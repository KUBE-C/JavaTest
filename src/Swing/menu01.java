package Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class menu01 extends JFrame {
  public menu01(){
      super("下拉式菜单");
      //创建菜单栏
      JMenuBar jMenuBar=new JMenuBar();
      //创建菜单
      JMenu menu=new JMenu("游戏选项");
      //将菜单添加到菜单栏上
      jMenuBar.add(menu);
      JMenuItem[] menuItems;
      String[] menuItemNames={"初级","中级","高级","退出"};
      menuItems=new JMenuItem[menuItemNames.length];
      for(int i=0;i<menuItemNames.length;i++){
          menuItems[i]=new JMenuItem(menuItemNames[i]);
          menu.add(menuItems[i]);
      }
      //添加事件监听器
      menuItems[3].addActionListener(new AbstractAction() {
          @Override
          public void actionPerformed(ActionEvent e) {
              System.exit(0);
          }
      });
      jMenuBar.add(menu);
      this.setJMenuBar(jMenuBar);  //添加到JFrame窗口中
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出系统
      this.setSize(300,300);
      this.setLocationRelativeTo(null);//居中
      this.setVisible(true);//可见
  }
    public static void main(String[] args) {
        new menu01();
    }
}
