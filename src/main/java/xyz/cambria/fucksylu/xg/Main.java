package xyz.cambria.fucksylu.xg;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @Author Cambria
 * @creat 2021/7/30 11:28
 */
public class Main {
    static String FILE_PATH = File.separator + "home" + File.separator + "Cambria" + File.separator + "FuckSYLU" + File.separator +
            "XG" + File.separator + "Temperature" + File.separator + "StuInfos" + File.separator;

    public static void main(String[] args) throws IOException {
        File[] files = new File(FILE_PATH).listFiles();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        System.out.println(FILE_PATH + " Found Files:");
        if (files == null)
            return;

        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println("\n\n\n");
        Properties properties = new Properties();

        for (File file : files) {
            try {
                properties.load(new FileReader(file));

                System.out.println(properties.getProperty("id"));

                String cookie = XGLogin.login(properties.getProperty("id"), properties.getProperty("pwd"));

                Temperature.run("0" , null , cookie);
                Temperature.run("8" , null , cookie);
                Temperature.run("16" , null , cookie);

                /*try {
                    InfoCollect.run(cookie , properties , GetInfoCollectForm.run(cookie));
                } catch (Exception e) {
                    System.out.println("没抓到健康状况表单信息,timestamp:" + System.currentTimeMillis());
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
