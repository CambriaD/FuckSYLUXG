package xyz.cambria.fucksylu.xg;

import java.io.*;

/**
 * @Author Cambria
 * @creat 2021/7/30 11:28
 */
public class Main {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/cookie.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] rawCookie = new char[1024];
        try {
            fileReader.read(rawCookie);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String cookie = new String(rawCookie);
        System.out.println(cookie.equals("CenterSoftWeb=61593E3B9F8C52E7D9B9F407D918A801792465D27D401403B15E4870E542A5FFF60C356F75DABE6305A8F5E38798D62DD90F0E2CE70DACAF22848BE7ABC5300B43E4F44E8DB497D57F83AE219AC6DDD2618B4F1440053DF5A303FB82151F6DBD1C44154E067FD3A91429E3BC4FD61AB8A586404B1349F0E79FAB000F5F4E47D15F37710F0E7701880E50577220E2D72DBD0D5559DC4D441516411CCB23434CA6312929AE98B250915AF466DB6BDF61BEEB187391A7F87C6F9A083828C469CB8A"));

        /*try {
            Temperature.httpPost("0" , "a8b91e21-8da4-4dfe-a66a-55337816f533" , "");
            Temperature.httpPost("8" , "7fcaf3f0-2053-4365-b149-6c0e847738cc" , cookie);
            Temperature.httpPost("16" , "7fcaf3f0-2053-4365-b149-6c0e847738dc" , cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
