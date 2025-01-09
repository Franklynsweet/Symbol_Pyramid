package index;

import javax.lang.model.type.NullType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

public class Style {

    public static void generateGUI() {
    //界面布局
        JFrame frame = new JFrame("_Symbol_Pyramid，  maker：Franklyn-Li，  School：ZhuHai University of Science and Technology");// 创建一个名为frame的JFrame对象，标题为"金字塔生成器"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭操作为退出应用程序
        frame.setSize(800, 800);// 设置窗口大小为800x800像素
        frame.setLayout(new BorderLayout());// 使用BorderLayout布局管理器设置窗口的布局

        JPanel panel = new JPanel();// 创建一个名为panel的JPanel对象，用于放置其他组件
        panel.setLayout(null);// 使用null布局管理器设置panel的布局

        JLabel symbolLabel = new JLabel("请输入您想用于金字塔的符号:");// 创建一个名为symbolLabel的JLabel对象，显示文本为"请输入您想用于金字塔的符号:"
        symbolLabel.setBounds(125, 50, 300, 30);// 在panel上设置symbolLabel的位置和大小
        panel.add(symbolLabel);//将名为symbolLabel标签添加到panel组件对象中


        JTextField symbolField = new JTextField(15);// 创建一个名为symbolField的JTextField对象，用于输入金字塔的符号
        symbolField.setBounds(300, 50, 200, 30);// 在panel上设置symbolField的位置和大小
        panel.add(symbolField);//将名为symbolField标签添加到panel组件对象中

        JLabel fileTypeLabel = new JLabel("选择文件类型:");// 创建一个名为fileTypeLabel的JLabel对象，显示文本为"选择文件类型:"
        fileTypeLabel.setBounds(550, 50, 120, 20);// 在panel上设置fileTypeLabel的位置和大小
        panel.add(fileTypeLabel);//将名为fileTypeLabel标签添加到panel组件对象中

        JComboBox<String> fileTypeComboBox = new JComboBox<>(new String[]{".txt",".doc",".xls",".pdf"});// 创建一个名为fileTypeComboBox的JComboBox对象，用于选择金字塔保存的文件类型，设置fileTypeComboBox的选项为".txt",".doc",".xls",".pdf"
        fileTypeComboBox.setBounds(650, 50, 100, 25);//在panel上设置fileTypeComboBox的位置和大小
        panel.add(fileTypeComboBox);//将名为fileTypeComboBox标签添加到panel组件对象中

        JButton saveButton = new JButton("保存");// 创建一个名为saveButton的JButton按钮对象，显示文本为"保存"
        saveButton.setBounds(650, 100, 100, 30);// 在panel上设置saveButton的位置和大小
        panel.add(saveButton);//将名为saveButton标签添加到panel组件对象中


        JLabel lineLabel = new JLabel("请输入金字塔的层数:");// 创建一个名为lineLabel的JLabel对象，显示文本为"请输入金字塔的层数:"
        lineLabel.setBounds(125, 100, 300, 30);// 在panel上设置lineLabel的位置和大小
        panel.add(lineLabel);//将名为lineLabel标签添加到panel组件对象中

        JTextField lineField = new JTextField(15);// 创建一个名为lineField的JTextField对象，用于输入金字塔的层数
        lineField.setBounds(300, 100, 200, 30);// 在panel上设置lineField的位置和大小
        panel.add(lineField);//将名为lineField标签添加到panel组件对象中

        JLabel colorLabel = new JLabel("请选择金字塔的颜色:");// 创建一个名为colorLabel的JLabel对象，显示文本为"请选择金字塔的颜色:"
        colorLabel.setBounds(125, 150, 300, 30);// 在panel上设置colorLabel的位置和大小
        panel.add(colorLabel);//将名为colorLabel标签添加到panel组件对象中

        JComboBox<String> colorBox = new JComboBox<>(new String[]{"黑色", "红色", "蓝色", "绿色"});// 创建一个名为colorBox的JComboBox对象，用于选择金字塔的颜色，设置colorBox的选项为"黑色", "红色", "蓝色", "绿色"
        colorBox.setBounds(300, 150, 200, 30);// 在panel上设置colorBox的位置和大小
        panel.add(colorBox);//将名为colorBox标签添加到panel组件对象中

        JButton generateBtn = new JButton("生成金字塔");// 创建一个名为generateBtn的JButton按钮对象，显示文本为"生成金字塔"
        generateBtn.setBounds(300, 200, 200, 40);// 在panel上设置generateBtn的位置和大小
        panel.add(generateBtn);//将名为generateBtn标签添加到panel组件对象中

        JButton CleanBtn = new JButton("清空");// 创建一个名为CleanBtn按钮对象，显示文本为"清空"
        CleanBtn.setBounds(650, 200, 100, 40);// 在panel上设置CleanBtn的位置和大小
        panel.add(CleanBtn);//将名为CleanBtn标签添加到panel组件对象中

        JTextArea resultTextArea = new JTextArea();// 创建一个名为resultTextArea的JTextArea对象，用于显示生成的金字塔结果
        resultTextArea.setEditable(false);// 将resultTextArea设置为不可编辑
        JScrollPane scrollPane = new JScrollPane(resultTextArea);  // 修改：添加滚动面板
        scrollPane.setBounds(50, 250, 700, 400);  // 修改：设置滚动面板的位置和大小
        panel.add(scrollPane);//将名为scrollPane标签添加到panel组件对象中



        //颜色获取，文本获取，按钮监听获取，错误提示，调用金字塔生成算法
        generateBtn.addActionListener(new ActionListener() {  // 添加按钮监听器
            @Override
            public void actionPerformed(ActionEvent e) {//这是 actionPerformed 方法的签名，当实现 ActionListener 接口时，系统会自动调用此方法，以响应与此 ActionListener 相关的组件上的操作（如按钮点击）。
                String lineText = lineField.getText();  // 获取输入的层数文本
                String symbol = symbolField.getText();  // 获取输入的符号
                String color = (String) colorBox.getSelectedItem();  // 获取选择的颜色

                //取反逻辑，当Tips.isInteger(lineText)为true，取反变为false则不执行if语句内的代码，如果Tips.isInteger(lineText)为false，取反为true，则执行if语句内的代码
                if (!Tips.isInteger(lineText)) {//结合报错内容解释：因为当用户输入内容不符合要求时我想要显示框不会出现任何内容所以在style文件中就是return 空 ;但是会执行Tips文件的代码进行报错提示，当用户输入的内容符合要求时就跳过这条语句
                    // 如果输入的层数不是有效的整数，显示错误提示
                    return;
                }

                int line = Integer.parseInt(lineText);  // 转换为整数
                String result = Algorithm.jinzita(line, symbol, color);  // 调用Algorithm文件中的jinzita方法,即生成金字塔的算法
                resultTextArea.setText(result);  // 将结果显示在文本区域中


                // 设置显示图案字体的颜色
                if ("黑色".equals(color)) {
                    resultTextArea.setForeground(Color.BLACK);
                } else if ("红色".equals(color)) {
                    resultTextArea.setForeground(Color.RED);
                } else if ("蓝色".equals(color)) {
                    resultTextArea.setForeground(Color.BLUE);
                } else if ("绿色".equals(color)) {
                    resultTextArea.setForeground(Color.GREEN);
                }
            }
        });


        saveButton.addActionListener(new ActionListener() {// 添加按钮监听器
            @Override
            public void actionPerformed(ActionEvent e) {//这是 actionPerformed 方法的签名，当实现 ActionListener 接口时，系统会自动调用此方法，以响应与此 ActionListener 相关的组件上的操作（如按钮点击）。
                String content = resultTextArea.getText();// 从resultTextArea中获取文本内容
                String selectedFileType = (String) fileTypeComboBox.getSelectedItem();// 获取用户在文件类型下拉框中选择的文件类型,并强转为String类型

                JFileChooser fileChooser = new JFileChooser();// 创建一个文件选择器对象，就是按保存之后跳出来的那个窗口，用来选择文件路径
                fileChooser.setDialogTitle("保存文档");// 设置文件选择器的对话框标题，按保存之后跳出来的那个窗口顶部名字

                // 创建文件过滤器，限制用户只能选择文本文件（.txt）、Word文件（.doc）、Excel文件（.xls）、PDF文件（.pdf）
                FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件 (*.txt), Word文件 (*.doc), Excel文件 (*.xls), PDF文件 (*.pdf)", "txt", "doc", "xls", "pdf");
                fileChooser.setFileFilter(filter);// 将文件过滤器设置到文件选择器中

                Tips.saveFile(fileChooser, frame, selectedFileType, content);// 调用Tips类中的saveFile方法，用于跳出提示框来提示用户的文件保存的路径
            }
        });

        CleanBtn.addActionListener(new ActionListener() {// 添加按钮监听器
            public void actionPerformed(ActionEvent e){//这是 actionPerformed 方法的签名，当实现 ActionListener 接口时，系统会自动调用此方法，以响应与此 ActionListener 相关的组件上的操作（如按钮点击）。
                resultTextArea.setText("");//将之前生成的内容设置成空
            }
        });


        resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));//把字体设置成等宽的字体形式从而实现视觉对称的效果
        frame.add(panel, BorderLayout.CENTER);// 将一个名为panel的组件添加到名为frame的顶级容器中，位置为CENTER（中间）。
        frame.setVisible(true);//设置frame窗口的可见性，使frame窗口显示在屏幕上。
    }

}

