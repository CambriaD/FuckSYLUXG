package xyz.cambria.fucksylu.xg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author Cambria
 * @creat 2021/8/1 16:41
 */
public class TempMain {
    static String FILE_PATH = "StuInfos/";

    public static void main(String[] args) throws IOException {
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

                System.out.println(properties.getProperty("id") + " Done");
            } catch (Exception e) {
                System.out.println(properties.get("id") + " Failed");
                e.printStackTrace();
            }
        }
    }
}
