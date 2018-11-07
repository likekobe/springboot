package com.how2java.springboot.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.*;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil
{
    
    public static void writeData(String filePath, Map<String, String> keyValueMap)
    {
        // 获取绝对路径
        filePath = PropertiesUtil.class.getResource("/" + filePath).toString();
        // 截掉路径的”file:/“前缀
        filePath = filePath.substring(6);
        Properties prop = new Properties();
        try
        {
            File file = new File(filePath);
            if (!file.exists())
                file.createNewFile();
            InputStream fis = new FileInputStream(file);
            prop.load(fis);
            // 一定要在修改值之前关闭fis
            fis.close();

            OutputStream fos = new FileOutputStream(filePath);

            for (String key : keyValueMap.keySet())
                prop.setProperty(key, keyValueMap.get(key));

            //prop.setProperty(key, value);
            // 保存，并加入注释
            prop.store(fos, "Update '" + keyValueMap + "' value");
            fos.close();
        }
        catch (IOException e)
        {
            System.err.println("Visit " + filePath + " for updating " + keyValueMap + " value error");
        }
    }
    
    public static void updateProperties(String fileName, Map<String, String> keyValueMap)
    {
        // getResource方法使用了utf-8对路径信息进行了编码，当路径中存在中文和空格时，他会对这些字符进行转换，这样，
        // 得到的往往不是我们想要的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的中文及空格路径。
        Properties props = null;
        BufferedWriter bw = null;
        
        try
        {
            String filePath = PropertiesUtil.class.getClassLoader().getResource(fileName).getFile();
            
            filePath = URLDecoder.decode(filePath, "utf-8");
            props = PropertiesLoaderUtils.loadProperties(new ClassPathResource(fileName));
            String old = props.getProperty("appName");
            // 写入属性文件
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            
            // props.clear();// 清空旧的文件
            
            for (String key : keyValueMap.keySet())
                props.setProperty(key, keyValueMap.get(key));
            
            props.store(bw, "");
            String newd = props.getProperty("appName");
            System.out.print(newd);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
