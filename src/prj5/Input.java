package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        SortedList<Song> list = null;
        if (args.length == 0) {
            try {
                list = parseFile(new File("SongList.csv"));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        if (list != null) {
            System.out.println(list.toString());
        }
        
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
        
        try {
            parseData(new File("MusicSurveyData.csv"), list);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public static SortedList<Song> parseFile(File file) throws FileNotFoundException {
        SortedList<Song> list = new SortedList<Song>();
        Scanner scan = new Scanner(file);
        scan.nextLine();
        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            String[] values = text.split(",");
            list.add(new Song(values[0], values[1],
                    values[3], Integer.parseInt(values[2])));
        }
        scan.close();
        return list;
    }
    
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
}
