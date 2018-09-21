package ch.bfh.javaytd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MP3converter {

    // MP3Converter.java

    /**
     *
     * @author Tunde Michael
     *
     */

        private static final Logger LOG = Logger.getLogger(MP3converter.class.getName());

        public static void main(String[] args) {

            try {
                String line;
                String mp4File = "C:\\Users\\anina\\OneDrive\\Dokumente\\Youtube-dl\\CalmDownDearestJ.mp4";
                String mp3File = "C:\\Users\\anina\\Music\\CalmDownDearestJ.mp3";

                // ffmpeg -i input.mp4 output.avi as it's on www.ffmpeg.org
                String cmd = "ffmpeg -i " + mp4File + " " + mp3File;
                Process p = Runtime.getRuntime().exec(cmd);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(p.getErrorStream()));
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
                p.waitFor();
                System.out.println("Video converted successfully!");
                in.close();
            } catch (IOException | InterruptedException e) {
                LOG.log(Level.SEVERE, null, e);
            }

        }

    }
