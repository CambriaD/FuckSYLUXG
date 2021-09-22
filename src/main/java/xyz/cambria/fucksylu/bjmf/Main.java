package xyz.cambria.fucksylu.bjmf;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import xyz.cambria.fucksylu.xg.Temperature;
import xyz.cambria.fucksylu.xg.XGLogin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @Author Cambria
 * @creat 2021/9/22 7:55
 */
public class Main {

    private static final String FILE_PATH = "StuInfos\\bjmf\\";

    public static void main(String[] args) throws IOException {

        /*Login.login("15804201356" , "");*/

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
                properties.load(new FileReader(file));

                String cookie = properties.getProperty("cookie");

                System.out.println(properties.getProperty("name"));

                List<BasicNameValuePair> payload = new ArrayList<>();

                String id = GetPunchId.getPunchId(cookie);
                String lat = "41.731407";
                String lng = "123.50237";
                String acc = "15.0";
                String gps_addr = "辽宁省沈阳市浑南区汇泉东路";
                String res = "";

                payload.add(new BasicNameValuePair("id" , id));
                payload.add(new BasicNameValuePair("lat" , lat));
                payload.add(new BasicNameValuePair("lng" , lng));
                payload.add(new BasicNameValuePair("acc" , acc));
                payload.add(new BasicNameValuePair("gps_addr" , gps_addr));
                payload.add(new BasicNameValuePair("res" , res));

                HttpPost post = new HttpPost("http://banjimofang.com/student/course/44987/punchs");

                CloseableHttpClient client = HttpClients.createDefault();

                post.setHeader("Cookie" , cookie);
                post.setEntity(new UrlEncodedFormEntity(payload));

                CloseableHttpResponse response = client.execute(post);

                System.out.println(EntityUtils.toString(response.getEntity()));

        }
    }

}
