package xyz.cambria.fucksylu.xg;

import java.io.*;
import java.util.Properties;

/**
 * @Author Cambria
 * @creat 2021/7/30 11:28
 */
public class Main {
    static String FILE_PATH = "StuInfos/";

    /*public static void main(String[] args) throws IOException {
        File[] files = new File(FILE_PATH).listFiles();
        if (files == null)
            return;
        Properties properties = new Properties();

        for (File file : files) {
            properties.load(new FileReader(file));

            String cookie = XGLogin.login(properties.getProperty("id"), properties.getProperty("pwd"));
            try {
                Temperature.run("0" , null , cookie);
                Temperature.run("8" , null , cookie);
                Temperature.run("16" , null , cookie);

                InfoCollect.run(cookie , properties , GetInfoCollectForm.run(cookie));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

    public static void main(String[] args) throws IOException {
        File[] files = new File(FILE_PATH).listFiles();
        if (files == null)
            return;
        Properties properties = new Properties();

        for (File file : files) {
            properties.load(new FileReader(file));

            String cookie = XGLogin.login(properties.getProperty("id"), properties.getProperty("pwd"));

            try {
                GetInfoCollectForm.run(cookie);
                InfoCollect.run(cookie , properties , GetInfoCollectForm.run(cookie));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
