package a_DefiningClassesEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(scanner.readLine());
        int totalSeconds = 0;
        int songsCounter = 0;
        for (int i = 0; i < n; i++) {
            String[] songParams = scanner.readLine().split(";");
            try {
                long songMinutes = Long.parseLong(songParams[2].split(":")[0]);
                long songSeconds = Long.parseLong(songParams[2].split(":")[1]);
                Song currentSong = new Song(songParams[0], songParams[1], songMinutes, songSeconds);
                totalSeconds += songSeconds + (songMinutes * 60);
                songsCounter++;
                System.out.println("Song added.");
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid song length.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Songs added: " + songsCounter);
        System.out.println("Playlist length: " + toSeconds(totalSeconds));
    }

    private static String toSeconds(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return hours + "h " + minutes + "m " + seconds + "s";
    }
}
