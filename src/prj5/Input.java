package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Input class that reads from a specificed 
 * command line file, SurveyData and SongList,
 * or two given files by default
 * @author Chris Dare cdare77
 * @version 11/20/2015
 */
public class Input {

    /**
     * main method which instantiates files
     * and calls static helper methods
     * @param args -args[0] SurveyData args[1] 
     * song list
     */
    public static void main(String[] args) {
        SortedList<Song> list = null;
        File songlist;
        File surveyData;
        
        if (args.length == 0) {
            songlist = new File("SongList.csv");
            surveyData = new File("MusicSurveyData.csv");
        }
        else {
            songlist = new File(args[1]);
            surveyData = new File(args[0]);
        }
        
        
        try {
            list = parseFile(songlist);
                
                
            /*
             * asserting songData is not null, but zeros
             */
            for (Song song : list) {
                song.setHobbyData(new SongData(0, 0),
                        new SongData(0, 0), new SongData(0, 0),
                        new SongData(0, 0));                   
                song.setMajorData(new SongData(0, 0),
                        new SongData(0, 0), new SongData(0, 0),
                        new SongData(0, 0));
                song.setRegionData(new SongData(0, 0),
                        new SongData(0, 0), new SongData(0, 0),
                        new SongData(0, 0));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
        try {
           parseData(surveyData, list);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        printData(list);
        list.setSortMethod("genre");
        printData(list);
        
        @SuppressWarnings("unused")
        DataVisualizationWindow window = new DataVisualizationWindow(list);
    }
    
    /**
     * Parses the SongList into a sorted list
     * @param file -File to read from
     * @return sortedList containing all elements
     * from songList
     * @throws FileNotFoundException
     */
    public static SortedList<Song> parseFile(File file) throws FileNotFoundException {
        SortedList<Song> list = new SortedList<Song>();
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            String[] values = text.split(",");
            if (values.length < 3) {
                continue;
            }
            list.add(new Song(values[0], values[1],
                    values[3],
                    Integer.parseInt(values[2])));
        }
        scan.close();
        return list;
    }
    
    /**
     * parses each song and increments their respective
     * Song Data
     * @param file -SurveyData
     * @param list -list of songs to iterate
     * @throws FileNotFoundException
     */
    public static void parseData(File file, SortedList<Song> list) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        //int listIndex = 0;
        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            String[] values = text.split(",");
            if (values[0].equals("Nr")) {
                continue;
            }
            else {
                if (values.length < 3) {
                    continue;
                }
                String major = values[2];
                String region = values[3];
                String hobby = values[4];
                
                for (int i = 5; i < values.length; i++) {
                    Song song = list.get((i - 5) / 2);
                    int isLike = (i - 5) % 2;
                    if (major.equals("Computer Science")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.compSci.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.compSci.likes++;
                            }
                        }
                    }
                    else if (major.equals("Other Engineering")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.enge.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.enge.likes++;
                            }
                        }
                    }
                    else if (major.equals("Math or CMDA")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.math.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.math.likes++;
                            }
                        }
                    }
                    else  {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.other.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.other.likes++;
                            }
                        }
                    }
                    
                    if (hobby.equals("reading")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.read.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.read.likes++;
                            }
                        }
                    }
                    else if (hobby.equals("sports")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.sports.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.sports.likes++;
                            }
                        }
                    }
                    else if (hobby.equals("music")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.music.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.music.likes++;
                            }
                        }
                    }
                    else {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.art.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.art.likes++;
                            }
                        }
                    }
                    if (region.equals("Southeast")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.sEast.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.sEast.likes++;
                            }
                        }
                    }
                    else if (region.equals("Northeast")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.nEast.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.nEast.likes++;
                            }
                        }
                    }
                    else if (region.equals("Outside of United States")) {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.foreign.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.foreign.likes++;
                            }
                        }
                    }
                    else {
                        if (isLike == 0) {
                            if (values[i].equals("Yes")) {
                                song.otherStates.listens++;
                            }
                        }
                        else {
                            if (values[i].equals("Yes")) {
                                song.otherStates.likes++;
                            }
                        }
                    }
                    
                    //end of parsing data
                    
                }
            }
        }
        
        scan.close();
    }
    
    /**
     * static helper method which outputs the
     * given data
     * @param list -list to prind data of
     */
    public static void printData(SortedList<Song> list) {
        Iterator<Song> it = list.iterator();
        while (it.hasNext()) {
            Song song = it.next();
            System.out.println("Song Title: " + song.getTitle());
            System.out.println("Song Artist: " + song.getArtist());
            System.out.println("Song Genre: " + song.getGenre());
            System.out.println("Song Year: " + song.getReleaseYear());
            System.out.println(song.representHobbies() + "\n");
        }
    }
}
