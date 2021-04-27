package com.blj.javawiki.file;

import java.io.*;
import java.util.Properties;

/**
 * Created by bailiangjin on 2017/2/9.
 */
class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "demo.txt";
//        readFileByChar(filePath);
//        readFileByCharArray(filePath);
//        getSystemInfo();

//        copyFileByBuffer(filePath,"demo_copy.txt");
        readFileByBytes(filePath);
    }

    private static void readFileByChar(String filePath) throws IOException {
        //创建一个文件读取流对象，和指定名称的文件相关联。
        //要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
        FileReader fr = new FileReader(filePath);

        //调用读取流对象的read方法。
        //read():一次读一个字符。而且会自动往下读。


        while (true) {
            int ch = fr.read();
            if (ch == -1)
                break;
            System.out.println("ch=" + (char) ch);
        }
        fr.close();
    }


    public static void readFileByCharArray(String filePath) throws IOException {

        FileReader fr = new FileReader(filePath);


        //定义一个字符数组。用于存储读到字符。
        //该read(char[])返回的是读到字符个数。
        char[] buf = new char[1024];

        int num = 0;
        while ((num = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, num));
        }

        fr.close();
    }

    public static void getSystemInfo() {

        Properties prop = System.getProperties();

        //因为Properties是Hashtable的子类，也就是Map集合的一个子类对象。
        //那么可以通过map的方法取出该集合中的元素。
        //该集合中存储都是字符串。没有泛型定义。

        System.out.println(prop.toString());


        //如何在系统中自定义一些特有信息呢？
        System.setProperty("mykey", "myvalue");


        //获取指定属性信息。
        String value = System.getProperty("os.name");

        System.out.println("value=" + value);


        //可不可以在jvm启动时，动态加载一些属性信息呢？
        String v = System.getProperty("mykey");

        System.out.println("v=" + v);


		/*
        //获取所有属性信息。
		for(Object obj : prop.keySet())
		{
			String value = (String)prop.get(obj);

			System.out.println(obj+"::"+value);
		}
		*/
    }

    public static void copyFileByBuffer(String sourceFilePath,String destFilePath)
    {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try
        {
            bufr = new BufferedReader(new FileReader(sourceFilePath));
            bufw = new BufferedWriter(new FileWriter(destFilePath));

            String line = null;

            while((line=bufr.readLine())!=null)
            {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();

            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("读写失败");
        }
        finally
        {
            try
            {
                if(bufr!=null)
                    bufr.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("读取关闭失败");
            }
            try
            {
                if(bufw!=null)
                    bufw.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("写入关闭失败");
            }
        }
    }

    /**
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    public static void readFileByBytes(String fileName) {
        File file = new File(fileName);
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.write(tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            System.out.println();
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            in = new FileInputStream(fileName);
            showAvailableBytes(in);
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}