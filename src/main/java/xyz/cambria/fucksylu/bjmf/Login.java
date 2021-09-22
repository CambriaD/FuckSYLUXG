package xyz.cambria.fucksylu.bjmf;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cambria
 * @creat 2021/9/22 21:53
 */
public class Login {

    public static String login(String username , String password) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        List<BasicNameValuePair> bnvps = new ArrayList<>();

        bnvps.add(new BasicNameValuePair("username" , username));
        bnvps.add(new BasicNameValuePair("password" , password));

        HttpPost post = new HttpPost("http://banjimofang.com/student/login?ref=%2Fstudent");
        post.setEntity(new UrlEncodedFormEntity(bnvps));

        CloseableHttpResponse response = client.execute(post);

        System.out.println(EntityUtils.toString(response.getEntity()));

        String cookie = response.getFirstHeader("Set-Cookie").toString();
        System.out.println(cookie);

        return cookie;
    }

}
