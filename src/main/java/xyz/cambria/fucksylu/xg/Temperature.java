package xyz.cambria.fucksylu.xg;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cambria
 * @creat 2021/7/30 11:16
 */
public class Temperature {
    /**
     *
     * @param hour 填报时间-小时
     * @param rsf ResubmitFlag，暂时意义不明
     * @param cookie 用户cookie
     * @throws Exception 正确操作的话应该不会抛异常吧
     * @return 操作是否成功（暂未实现判断）
     */
    public static boolean run(String hour , String rsf , String cookie) throws Exception {
        boolean flag = false;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建一个HttpPost对象实例，对应Post请求
            HttpPost httpPost = new HttpPost("http://xg.sylu.edu.cn/SPCP/Web/Temperature/StuTemperatureInfo");

            //NameValuePair接口定义了用作 HTTP 消息元素的名称/值对参数。
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("TimeNowHour", hour));
            nvps.add(new BasicNameValuePair("TimeNowMinute", "0"));
            nvps.add(new BasicNameValuePair("Temper1", "36"));
            nvps.add(new BasicNameValuePair("Temper2", "0"));
            nvps.add(new BasicNameValuePair("ReSubmiteFlag", rsf));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setHeader("Cookie",cookie);

            //执行http请求
            CloseableHttpResponse response = httpclient.execute(httpPost);

            try {
                System.out.println(response);
                System.out.println(EntityUtils.toString(response.getEntity()));
                HttpEntity entity2 = response.getEntity();
                // 对响应主体做一些有用的事情并确保它被完全消耗掉
                EntityUtils.consume(entity2);
                //释放资源
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return flag;
    }
}
