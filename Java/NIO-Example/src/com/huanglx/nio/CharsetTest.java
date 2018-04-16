package com.huanglx.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) throws UnsupportedEncodingException, CharacterCodingException {
//        SortedMap<String, Charset> map = Charset.availableCharsets();
//        for (String alias : map.keySet()) {
//            System.out.println(alias);
//        }

        Charset charset = Charset.forName("UTF-8");
        //解码器
        CharsetDecoder decoder = charset.newDecoder();

        //编码器
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer charBuffer = decoder.decode(ByteBuffer.wrap("天天向上".getBytes("UTF-8")));
        System.out.println(charBuffer.toString());

        ByteBuffer byteBuffer = encoder.encode(CharBuffer.wrap("好好学习"));

        for (int i = 0; i < byteBuffer.capacity()-1; i++) {
            System.out.print(byteBuffer.get(i)+" ");
        }

        for (byte b :
                byteBuffer.array()) {
            System.out.print(b);
        }
    }
}
