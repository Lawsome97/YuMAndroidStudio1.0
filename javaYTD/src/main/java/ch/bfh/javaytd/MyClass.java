package ch.bfh.javaytd;

import java.io.PrintWriter;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello Java World");

        String download_path="C:\\Users\\anina\\OneDrive\\Dokumente\\Youtube-dl";
        String url="https://www.youtube.com/watch?v=F2Wm4Dh5yCk";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl "+url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
