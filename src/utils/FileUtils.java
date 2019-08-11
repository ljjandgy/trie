package utils;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FileUtils
 * @Description
 * @Author ljj
 * @Version V2.0.0
 * @Date 2019-08-10 22:39:51
 */
public class FileUtils {
    public static List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader,1024*1024)){
            //获取所有单词
            String line = "";
             while (null!=(line = bufferedReader.readLine())){
                 list.addAll(Arrays.asList(line.split(" ")));
             }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
}
