/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Đỗ Trung Đức
 */
public class MyUtils {

    public String getCurrentWorkingDir() {
        return System.getProperty("user.dir");
    }

    public void downloadMP3(String strURL) {
        String command = "";
        command += getCurrentWorkingDir()
                + "\\youtubeDL\\youtube-dl --extract-audio --audio-format mp3 --audio-quality 0 --add-metadata "
                + "--metadata-from-title " + '"' + "%(artist)s - %(title)s" + '"' + " "
                + "--output " + '"' + "%USERPROFILE%\\Downloads\\%(title)s.%(ext)s" + '"' + " "
                + '"' + strURL + '"';
        executeCommand(command);
    }

    private void executeCommand(String command) {
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
        } catch (IOException | InterruptedException e) {
        }
    }

    public boolean validateURL(String URL) {
        String regex = "^(https\\:\\/\\/)(www\\.youtube\\.com\\/watch\\?v=).+$";
        return URL.matches(regex);
    }
}
