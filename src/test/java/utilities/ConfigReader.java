package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;


static {//tum methodlardan method dan once calisir
        String filePath="configuration.properties";
    try {
        FileInputStream fis=new FileInputStream(filePath);
        properties=new Properties();
        properties.load(fis);//fis in okudugu bilgileri properties e yukledi
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


    public static String getProperty(String key){
        /*
        test methodundan yolladigimiz String key degerini alip
        Properties class indan getProperty() methodunu kullanarak
        bu key e ait value yu bize getirir
         */
        return properties.getProperty(key);//
    }




}
