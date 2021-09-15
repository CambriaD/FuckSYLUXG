package xyz.cambria.fucksylu.xg;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InfoCollect {
    static final String PZDATA = "[{\"OptionName\":\"是\",\"SelectId\":\"e2f169d0-0778-4e3e-8ebf-64ce5a44f307\",\"TitleId\":\"926853bd-6292-48ef-b554-0ea0cb99b808\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"2d520bb1-8632-4d77-b6de-9506df20bdcf\",\"TitleId\":\"356b07ea-5c32-4480-9982-28c85a8a9efa\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"a884f81e-f401-451d-9f3d-0526aa886feb\",\"TitleId\":\"6f95a926-c6d6-4fa7-9d74-fbcfcd79ec7b\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"62ad9bed-3201-4607-b845-5e279a0311d0\",\"TitleId\":\"6cd479f3-dd6a-4bab-809a-3abdf28e5a46\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"57722ddd-3093-4978-86da-1213420f36c4\",\"TitleId\":\"e6f578a6-6a0d-4b17-a18f-f1de3cb81d29\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"c6bcc8ce-86f1-404c-b7f8-ac583d899c75\",\"TitleId\":\"23dfd17a-84b0-462c-a27d-fbafbe670278\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"12727e9b-cd2f-413e-ae30-36adafd5203f\",\"TitleId\":\"0428ad6d-0c14-4c38-81fb-dc6928ae6608\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"e0559a52-d3d1-4203-ac9a-d221506a507f\",\"TitleId\":\"85e00a79-176f-4fcf-8d14-8bb14075d51f\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"c16d5a27-5923-43d8-b6a6-d5733803490b\",\"TitleId\":\"bd5a0708-79a3-4c92-a978-03aba2dac8a8\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"3a5fbe75-7bf4-4b6d-93f1-f561dbbf0ead\",\"TitleId\":\"91d7f9a5-aed8-462f-81f5-9d339c3f2d3a\",\"OptionType\":\"0\"},{\"OptionName\":\"否\",\"SelectId\":\"3a36a22f-5af7-4b48-a472-7df55a8ba374\",\"TitleId\":\"025d0800-de7d-45e3-b2b4-c240bec5aa51\",\"OptionType\":\"0\"}]";

    public static boolean run(String cookie , Properties pps , List<NameValuePair> list) throws IOException {
        HttpPost httpPost = new HttpPost("http://xg.sylu.edu.cn/SPCP/Web/Report/Index");

        list.add(new BasicNameValuePair("StudentId" , pps.getProperty("id")));
        list.add(new BasicNameValuePair("Name" , pps.getProperty("name")));
        list.add(new BasicNameValuePair("Sex" , pps.getProperty("sex")));
        list.add(new BasicNameValuePair("SpeType" , "B"));
        list.add(new BasicNameValuePair("CollegeNo" , pps.getProperty("id").substring(2,4)));
        list.add(new BasicNameValuePair("SpeGrade" , new String("20" + pps.getProperty("id").substring(0,2))));
        list.add(new BasicNameValuePair("SpecialtyName" , pps.getProperty("SpecialtyName")));
        list.add(new BasicNameValuePair("ClassName" , pps.getProperty("ClassName")));
        list.add(new BasicNameValuePair("MoveTel" , pps.getProperty("tel")));
/*        list.add(new BasicNameValuePair("Province" , new String(pps.getProperty("IDNum").substring(0,2) + "0000")));
        list.add(new BasicNameValuePair("City" , new String(pps.getProperty("IDNum").substring(0,4) + "00")));
        list.add(new BasicNameValuePair("County" , pps.getProperty("IDNum").substring(0,6)));*/
        list.add(new BasicNameValuePair("Province" , "210000"));
        list.add(new BasicNameValuePair("City" , "210100"));
        list.add(new BasicNameValuePair("County" ,"210110"));
        list.add(new BasicNameValuePair("ComeWhere" , pps.getProperty("address")));
        list.add(new BasicNameValuePair("FaProvince" , new String(pps.getProperty("IDNum").substring(0,2) + "0000")));
        list.add(new BasicNameValuePair("FaCity" , new String(pps.getProperty("IDNum").substring(0,4) + "00")));
        list.add(new BasicNameValuePair("FaCounty" , pps.getProperty("IDNum")));
        list.add(new BasicNameValuePair("FaComeWhere" , pps.getProperty("familyaddress")));
        /*list.add(new BasicNameValuePair("radio_1" , "e2f169d0-0778-4e3e-8ebf-64ce5a44f307"));
        list.add(new BasicNameValuePair("radio_2" , "2d520bb1-8632-4d77-b6de-9506df20bdcf"));
        list.add(new BasicNameValuePair("radio_3" , "a884f81e-f401-451d-9f3d-0526aa886feb"));
        list.add(new BasicNameValuePair("radio_4" , "62ad9bed-3201-4607-b845-5e279a0311d0"));
        list.add(new BasicNameValuePair("radio_5" , "57722ddd-3093-4978-86da-1213420f36c4"));
        list.add(new BasicNameValuePair("radio_6" , "c6bcc8ce-86f1-404c-b7f8-ac583d899c75"));
        list.add(new BasicNameValuePair("radio_7" , "12727e9b-cd2f-413e-ae30-36adafd5203f"));
        list.add(new BasicNameValuePair("radio_8" , "e0559a52-d3d1-4203-ac9a-d221506a507f"));*/
        list.add(new BasicNameValuePair("text_1" , ""));
        /*list.add(new BasicNameValuePair("radio_9" , "c16d5a27-5923-43d8-b6a6-d5733803490b"));
        list.add(new BasicNameValuePair("radio_10" , "3a5fbe75-7bf4-4b6d-93f1-f561dbbf0ead"));
        list.add(new BasicNameValuePair("radio_11" , "3a36a22f-5af7-4b48-a472-7df55a8ba374"));*/
        list.add(new BasicNameValuePair("Other" , ""));
        list.add(new BasicNameValuePair("GetAreaUrl" , "/SPCP/Web/Report/GetArea"));
        list.add(new BasicNameValuePair("IdCard" , pps.getProperty("IDNum")));
        list.add(new BasicNameValuePair("ProvinceName" , pps.getProperty("Province")));
        list.add(new BasicNameValuePair("CityName" , pps.getProperty("City")));
        list.add(new BasicNameValuePair("CountyName" , pps.getProperty("Country")));
        list.add(new BasicNameValuePair("FaProvinceName" , pps.getProperty("Province")));
        list.add(new BasicNameValuePair("FaCityName" , pps.getProperty("City")));
        list.add(new BasicNameValuePair("FaCountyName" , pps.getProperty("Country")));
        list.add(new BasicNameValuePair("checkboxCount" , "0"));
        list.add(new BasicNameValuePair("blackCount" , "1"));
        /*list.add(new BasicNameValuePair("PZData" , PZDATA));
        list.add(new BasicNameValuePair("ReSubmiteFlag" , ""));*/
        System.out.println(list.toString());
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list));
            httpPost.setHeader("Cookie" , cookie);
            httpPost.setHeader("Content-Type" , "application/x-www-form-urlencoded; charset=utf-8");
            httpPost.setHeader("User-Agent" , "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36 Edg/92.0.902.55");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);

        System.out.println(EntityUtils.toString(response.getEntity()));

        return false;
    }

}
