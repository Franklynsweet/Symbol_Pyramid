package index;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tips {
    public static boolean isInteger(String s) {
        try {
            int num = Integer.parseInt(s);//输入的值为整数

            if(num>0){//当输入的值为大于0的整数时
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null, "金字塔的层数应为大于0的整数！");//否则提示："金字塔的层数应为大于0的整数！"
                return false;
            }
        } catch (NumberFormatException e) {//当以上条件均不满足时
            JOptionPane.showMessageDialog(null, "金字塔的层数应为大于0的整数！");//提示："金字塔的层数应为大于0的整数！"
            return false;
        }



    }
    public static void saveFile(JFileChooser fileChooser, JFrame frame, String selectedFileType, String content) {
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            if (!filePath.toLowerCase().endsWith(selectedFileType)) {
                filePath += selectedFileType;
            }

            try {
                if (selectedFileType.equals(".txt")) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "文本文件已保存到: " + filePath);
                } else if (selectedFileType.equals(".doc")) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Word文件已保存到: " + filePath);
                } else if (selectedFileType.equals(".xls")){
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Excel文件已保存到: " + filePath);
                } else if (selectedFileType.equals(".pdf")) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "PDF文件已保存到: " + filePath);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "保存文件时出现错误");
            }
        }
    }
}
