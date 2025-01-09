package index;

//import javax.swing.*;
//import javax.swing.filechooser.FileNameExtensionFilter;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
        //金字塔算法本体
        public static String jinzita(int line, String symbol,String color) {
            StringBuilder builder = new StringBuilder();
            int symbolLength = symbol.length();

            for (int i = 1; i <= line; i++) {
                int spaceCount = (line - i) * symbolLength;//求出每行一共的空格数量
                int symbolCount = 2 * i - 1;//求出每行的符号数量（以用户输入的的符号作为一个单位，并不是一个字符为一个符号，因为用户输入的符号长度不一定是1），并且每层的的符号数是成等差数列进行的

                // 判断符号是否包含中文字
                if (containsChineseCharacters(symbol)) {
                    // 如果包含中文字，将空格替换为全角空格
                    for (int j = 0; j < spaceCount; j++) {
                        builder.append("　"); // 全角空格,先是左边输出，原理：当用户的符号中有多少个中文字符就输出多少个全角空格
                    }
                    for (int k = 0; k < symbolCount; k++) {
                        builder.append(symbol);//然后在中间输出每一层计算之后的符号数量
                    }
                    for (int j = 0; j < spaceCount; j++) {
                        builder.append("　");//右边输出，与左边输出数量一样，所以可以使左右对称
                    }
                    builder.append('\n');//每行输出完之后换行
                } else {//如果不是中文字符的部分，原理同上
                    for (int j = 0; j < spaceCount; j++) {
                        builder.append(" ");
                    }
                    for (int k = 0; k < symbolCount; k++) {
                        builder.append(symbol);
                    }
                    for (int j = 0; j < spaceCount; j++) {
                        builder.append(" ");
                    }
                    builder.append('\n');
                }

            }
            return builder.toString();//将一个 StringBuilder 对象builder转换为字符串并返回。
        }

        // 判断字符串中是否包含中文字
        private static boolean containsChineseCharacters(String str) {//当调用这个函数时str会获取所调用的内容symbol
            String pattern = "[\\u4e00-\\u9fa5]";//定义一个字符串变量pattern，其值为'[\u4e00-\u9fa5]'，这是一个正则表达式，用于匹配所有中文字符的Unicode编码。
            Pattern p = Pattern.compile(pattern);//使用Pattern类中的compile方法将pattern编译为一个Pattern对象，编译之后把它装在p中可以更方便之后要对其他变量进行匹配的操作，简单来说就是把pattern编译成Pattern然后赋给p。
            Matcher m = p.matcher(str);//使用Matcher类中的matcher方法将str与pattern进行匹配，返回一个Matcher对象m。这个对象可以用于在str中查找匹配pattern的子串。
            return m.find();//最后，调用Matcher对象的find方法，如果找到了匹配的子串，该方法会返回true，否则返回false。这个方法最终返回的结果就是这个字符串中是否包含中文字符。
        }
    }

//原始代码思维
/*
//导入数据包
import java.sql.SQLOutput;
import java.util.Scanner;
public class First {
    public static void main(String[] args){
        //1,设计Scanner类
        Scanner input = new Scanner(System.in);
        //2，提示用户输入需要的行数
        System.out.println("请输入金字塔层数");
        //3，获取用户输入的行数赋值给line
        int line = input.nextInt();
        //4，从用户输入读取符号
        System.out.println("请输入您想用于金字塔的符号：");
        String symbol = input.next();
        //5，定义i，j,k整数
        int i,j,k;
        //6，这里for循环是对用户输入的行数进行循环。
        // 若是用户输入5行，则在此循环5次，每次输出一个换行符，共计5行。
        for(i=1;i<=line;i++){
            //7，这里的循环是实现输出星号前面的空格。
            //若是用户输入5行，则在第一行循环4次（循环次数等于n减去行数），每次输出一个星号，以此类推。
            for(j=1;j<=line-i;j++){
                System.out.print(" ");
            }
            //8，这里的循环是实现输出每一行的星号。
            //如第一行，i=1时循环一次，每次输出一个星号，共计1个星号。
            //如第二行，i=2时循环三次，每次输出一个星号，共计3个星号。以此类推。
            for(k=1;k<=2*i-1;k++){
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
*/
/*算法迭代
第一代：缺点：当符号长度不为1时就会不对称
        //第一个大循环：层数，由i到层数依次增加一
        for (int i = 1; i <= line; i++) {
            //第一个大循环内的第一个循环：空格，原理：最后一层全都是符号，没有空格，每一层的空格=层数-当前层数，依次推理得第一层空格=层数-1，相当于减去第一层的符号数1
            for (int j = 1; j <= line - i; j++) {
                builder.append(" ");
            }
            //第一个大循环内的第二个循环：符号，原理：我们要的是金字塔，那么每一层总有符号（组成金字塔的符号不一定是单个符号，可能是8.1）的位置与第一层的符号在同一列
            // 因此每一层除去这一列的符号之外，下一列的符号数量都比上一列的符号数量多两个，所以，每一层的符号数量=2*当前层数-1，呈等差数列（1,3,5,7.......）
            for (int k = 1; k <= i * 2 - 1; k++) {
                builder.append(symbol);  // 修改：将 '*' 替换为符号参数
            }
            //每层输出完后输出换行
            builder.append("\n");
        }

第二代：缺点当输入的符号是中文的时候出现金字塔不对称的情况
        //获取用户输入的符号的长度
        int symbolLength = symbol.length();

        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line - i; j++) {
                builder.append(" ".repeat(symbolLength)); // 输出额外的空格，实现左边对齐，解释：就是原本上下层只相差一个空格，现在是把原来相差的那一个空格换成与用户输入的符号长度相同的空格
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                builder.append(symbol);
            }
            for (int j = 1; j <= line - i; j++) {
                builder.append(" ".repeat(symbolLength)); // 输出右边的空格，实现左右对齐，与左边同理：右边就只需要输出与用户输入的符号长度相同的空格即可
            }
            builder.append('\n');
        }
* */