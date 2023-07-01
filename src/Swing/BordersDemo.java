package Swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BordersDemo extends JFrame {
    /** 按照参数指定的边框创建一个JPanel对象 */
    public static JPanel getPanelWithBorder(Border b){
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        String nm = b.getClass().toString();//获得边框对象b的完整的类名  eg：得到javax.swing.border.TitleBorder
        nm = nm.substring(nm.lastIndexOf('.')+1);//去掉前缀包名  eg：上述去掉包名得到TitleBorder
        //在JPanel中央有一个JLabel，它显示边框类的名字
        jp.add(new JLabel(nm,JLabel.CENTER),BorderLayout.CENTER);
        jp.setBorder(b);//设置JPanel的边框
        return jp;
    }
    //构造方法
    public BordersDemo(String title){
        super(title);
        setLayout(new GridLayout(2,4));//2行4列
        add(getPanelWithBorder (new TitledBorder("Title")));//带标题的边框
        add(getPanelWithBorder (new EtchedBorder()));//嵌入式的边框
        add(getPanelWithBorder (new LineBorder(Color.BLUE)));//带有边界线的边框，边界线颜色为蓝色
        add(getPanelWithBorder(new MatteBorder(5,5,30,30,Color.PINK)));
        add(getPanelWithBorder (new BevelBorder(BevelBorder.RAISED)));//凸起来的边框
        add(getPanelWithBorder (new SoftBevelBorder(BevelBorder.LOWERED)));//凹下去的边框
        add(getPanelWithBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.BLUE))));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();//调整窗口的大小，使其适应组件的大小和布局
        setVisible(true);
    }
    public static void main(String[] args) {
        new BordersDemo("Hello");
    }
}

