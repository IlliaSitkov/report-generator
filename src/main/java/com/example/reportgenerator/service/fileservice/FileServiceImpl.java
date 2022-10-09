package com.example.reportgenerator.service.fileservice;

import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public byte[] getFileByteArray(String fileName) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
            int read;
            byte[] buff = new byte[1024];
            while ((read = inputStream.read(buff)) != -1) {
                bos.write(buff, 0, read);
            }
            return bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
