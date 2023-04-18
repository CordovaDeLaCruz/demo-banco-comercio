package com.banco.demo.commons.features.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class CommonUtil {

    public static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }

        return phrase.toString();
    }

    public static String random(int length) {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                + "@#$%&/()=?¿*,.";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public static File saveBitmap(Context context, Bitmap bmp) {
        OutputStream outStream = null;
        long temp = new Date().getTime();
        File file = CommonUtil.getFileShared(context);
        try {
            outStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return file;
    }


    private static File getFileShared(Context context) {
        String timeStamp = "IMG_" + (new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));
        return getFileShared(context, timeStamp);


    }

    private static File getFileShared(Context context, String url) {
        // For a more secure solution, use EncryptedFile from the Security library
        // instead of File.
        File file = null;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(fileName, ".png", context.getCacheDir());
        } catch (IOException e) {
            // Error while creating file
        }
        return file;
    }


    public static File getCreateOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Pichincha");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
    }


    public static File getCreateOutputMediaFile(String name) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Pichincha");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        return new File(mediaStorageDir.getPath() + File.separator +
                name);
    }

    public static String convertPhrase(String word){
        String wordAux = word.toLowerCase(Locale.ROOT);
        char[] wordConverter = wordAux.toCharArray();
        for (int i = 0; i < word.length()-2; i++){
            if(i==0){
                wordConverter[i] = Character.toUpperCase(wordConverter[i]);
            }
            if (wordConverter[i] == ' ' || wordConverter[i] == '.' || wordConverter[i] == ',')
                wordConverter[i + 1] = Character.toUpperCase(wordConverter[i + 1]);
        }
        return new String(wordConverter);
    }
}
