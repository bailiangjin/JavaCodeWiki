package com.blj.javawiki.file;

import java.io.*;
import java.util.Date;

/**
 * Created by bailiangjin on 2017/2/9.
 */
public class WriteFileDemo {

    public static void main(String[] args) throws IOException {
//        writeFileCommon();
//        writeFileCatchException();
        writeFileAppendToTheEnd();
    }

    private static void writeFileCommon() throws IOException {
        //创建一个FileWriter对象。该对象一被初始化就必须要明确被操作的文件。
        //而且该文件会被创建到指定目录下。如果该目录下已有同名文件，将被覆盖。
        //其实该步就是在明确数据要存放的目的地。
        FileWriter fw = new FileWriter("demo.txt");

        //调用write方法，将字符串写入到流中。
        fw.write("abcde");

        //刷新流对象中的缓冲中的数据。
        //将数据刷到目的地中。
        //fw.flush();


        //关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据。
        //将数据刷到目的地中。
        //和flush区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
        fw.close();
    }


    public static void writeFileCatchException() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("TryCatchFileDemo.txt");
            fw.write("abcdefg");

        } catch (IOException e) {
            System.out.println("catch:" + e.toString());
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        }

    }

    public static void writeFileAppendToTheEnd() throws IOException {

        //传递一个true参数，代表不覆盖已有的文件。并在已有文件的末尾处进行数据续写。
        FileWriter fw = new FileWriter("demo.txt", true);

        String dateStr = new Date().toString();

        fw.write("\n" + dateStr + ":appendContent");

        fw.close();
    }


}