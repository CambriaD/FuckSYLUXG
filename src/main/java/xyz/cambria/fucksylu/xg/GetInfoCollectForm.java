package xyz.cambria.fucksylu.xg;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cambria
 * @creat 2021/7/31 18:40
 */
public class GetInfoCollectForm {

    private static final String URL = "http://xg.sylu.edu.cn/SPCP/Web/Report/Index";

    static List<NameValuePair> run(String cookie) throws Exception {
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setHeader("Cookie",cookie);
        String page = EntityUtils.toString(HttpClients.createDefault().execute(httpGet).getEntity());

        List<NameValuePair> data = new ArrayList<>();
        List<String> pzdata = new ArrayList<>();

        PZData r1 = new PZData();
        r1.setOptionName("是");
        int radio_1 = page.indexOf("radio_1");
        String substring = page.substring(0, radio_1);
        page = page.substring(radio_1);
        r1.setTitleId(substring.substring(substring.indexOf("data-tid")+10,substring.indexOf("data-tid")+46));
        r1.setSelectId(page.substring(13,49));
        r1.setOptionType("0");
        data.add(new BasicNameValuePair("radio_1" , r1.getSelectId()));
        pzdata.add(JSON.toJSONString(r1));
        int i = 2;

        try {
            for (i = 2; i < 20; i++) {
                PZData pzData = new PZData();
                pzData.setOptionType("0");
                pzData.setOptionName("否");
                String index = "radio_" + i;
                substring = page.substring(0 , page.indexOf(index));
                page = page.substring(page.indexOf(index));
                pzData.setTitleId(substring.substring(substring.lastIndexOf("data-tid")+10,substring.lastIndexOf("data-tid")+46));
                //pzData.setSelectId(page.substring(13,49));

                pzData.setSelectId(page.substring(page.indexOf(">否</label>")-37 , page.indexOf(">否</label>")-1));

                data.add(new BasicNameValuePair(index , pzData.getSelectId()));
                pzdata.add(JSON.toJSONString(pzData));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int reSubmiteFlag = page.indexOf("ReSubmiteFlag");
        data.add(new BasicNameValuePair("ReSubmiteFlag" , page.substring(reSubmiteFlag+36 , reSubmiteFlag+72)));

        data.add(new BasicNameValuePair("PZData" , pzdata.toString()));


        data.add(new BasicNameValuePair("radioCount" , String.valueOf(i)));

        System.out.println(data);

        return data;
    }

}
