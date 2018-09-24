package ch.bfh.javaytd;

import java.io.PrintWriter;

public class MyClass {
    public static void main(String[] args) {

        String download_path="C:\\Users\\anina\\OneDrive\\Dokumente\\Youtube-dl";
        String destination_path= "C:\\Users\\anina\\Music";
        String url="";

        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd");
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl   --extract-audio    --audio-format mp3  --audio-quality 0  "+ url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
