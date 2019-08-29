package tests;


import java.util.HashMap;
import java.util.Map;

class Solution {
    private boolean isMusic(String fileName) {
        return (fileName.endsWith(".mp3") || fileName.endsWith(".acc") || fileName.endsWith(".flac"));
    }
    private boolean isImage(String fileName) {
        return (fileName.endsWith(".jpg") || fileName.endsWith(".bmp") || fileName.endsWith(".gif"));
    }
    private boolean isMovie(String fileName) {
        return (fileName.endsWith(".mp4") || fileName.endsWith(".avi") || fileName.endsWith(".mkv"));
    }

    public String solution(String S) {
        String[] lines = getLines(S);
        Map<String, Long> fileTypes = new HashMap<>();
        fileTypes.put("music",0l);
        fileTypes.put("images",0l);
        fileTypes.put("movies",0l);
        fileTypes.put("other",0l);
        for (String line: lines) {
            String [] elements = line.split(" ");
            String fileName = elements[0].trim();
            Long size = Long.parseLong(elements[1].trim().replace("b",""));
            if (isMusic(fileName)) {
                fileTypes.put("music", fileTypes.get("music") + size);
            } else {
                if (isImage(fileName)) {
                    fileTypes.put("images", fileTypes.get("images") + size);
                } else {
                    if (isMovie(fileName)) {
                        fileTypes.put("movies", fileTypes.get("movies") + size);
                    } else {
                        fileTypes.put("other", fileTypes.get("other") + size);
                    }
                }
            }
        }
        return formatString(fileTypes);
    }

    private String formatString(Map<String, Long> fileTypes) {
        return String.format("music %sb\n" +
                      "images %sb\n" +
                      "movies %sb\n" +
                      "other %sb",
                    fileTypes.get("music"), fileTypes.get("images"), fileTypes.get("movies"), fileTypes.get("other"));
    }

    private String[] getLines(String S) {
        return S.split("\n");
    }

    public static void main(String[] args) {
        String S = "my.song.mp3 11b\n" +
                "greatSong.flac 1000b\n" +
                "not3.txt 5b\n" +
                "video.mp4 200b\n" +
                "game.exe 100b\n" +
                "mov!e.mkv 10000b";
        Solution solution = new Solution();
        System.out.println(solution.solution(S));
    }
}

public class App 
{
    public static void main( String[] args )
    {

    }
}
