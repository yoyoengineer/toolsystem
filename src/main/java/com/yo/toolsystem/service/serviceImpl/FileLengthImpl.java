package com.yo.toolsystem.service.serviceImpl;

import com.yo.toolsystem.service.FileLength;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Yoy on 2017/4/25.
 */
@Service
public class FileLengthImpl implements FileLength {
    public long getFileLength(String path, String userAgent) {
        long nFileLength=-1;
        try {
            URL url = new URL(path);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestProperty("User-Agent", userAgent);
            int responseCode = httpConnection.getResponseCode();
            if(responseCode>=400){
                System.out.println("responseCode:"+responseCode);
                 return -2; //-2 represent access is error
                 }
            String sHeader;
            for (int i = 1;; i++){
                sHeader = httpConnection.getHeaderFieldKey(i);
                if (sHeader != null) {
                    if (sHeader.equals("Content-Length")) {
                        nFileLength = Integer.parseInt(httpConnection.getHeaderField(sHeader));
                        break;
                    }
                } else
                    break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nFileLength;
    }
}
