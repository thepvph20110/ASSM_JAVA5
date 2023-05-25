package com.ASSM.thepv.utill.convert;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


/**
 * @author thepvph20110
 */
public class StringToMultipartFileConverter {
    public static MultipartFile convert(String content, String filename) throws Exception{
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        InputStream inputStream = new ByteArrayInputStream(contentBytes);
        String imgName = filename.substring(filename.lastIndexOf("\\") + 1);
        return new MockMultipartFile(imgName, imgName, null, inputStream);
    }
}
