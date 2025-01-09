package index;

//import java.util.Scanner;
//import javax.swing.*;
//import javax.swing.*;
import javax.swing.SwingUtilities;

//定义了一个公共类名为"First"。
public class First {
    //程序的入口点，当程序运行时，从这里开始执行。
    public static void main(String[] args) {
        //使用 SwingUtilities 类的 invokeLater 方法，将后续的代码块放入事件调度线程中执行，以确保界面在事件调度线程上创建。并创建一个匿名的 Runnable 对象，并重写其中的 run 方法。
        SwingUtilities.invokeLater(new Runnable() {
            //run 方法是 Runnable 接口的抽象方法，需要在其中定义具体的任务内容
            public void run() {
                //调用style文件中的 Style（可起名） 类的静态方法 generateGUI()（可起名），用于创建界面对象并显示。
                Style.generateGUI();
//                Print.print();
            }
        });
    }
}

