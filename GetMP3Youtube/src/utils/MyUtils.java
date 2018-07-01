/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;

/**
 *
 * @author Đỗ Trung Đức
 */
public class MyUtils {

    public void downloadMP3(String strURL, String folderSave) {
        String command = "";
        command += getCurrentWorkingDir()
                + "\\youtubeDL\\youtube-dl --extract-audio --audio-format mp3 --audio-quality 320k --add-metadata "
                + "--metadata-from-title " + '"' + "%(artist)s - %(title)s" + '"' + " "
                + "--output " + '"' + folderSave +"%(title)s.%(ext)s" + '"' + " "
                + '"' + strURL + '"';
        executeCommand(command);
    }

    private String getCurrentWorkingDir() {
        return System.getProperty("user.dir");
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
