package ua.timetabletrain;



import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("folderProject\\Timetable.xml");
        File tofile = new File("folderProject\\toTimetable.xml");

        Parser parserXML = new Parser(file, tofile);
        TimeTableTrain newTimeTable = (TimeTableTrain) parserXML.getObject(TimeTableTrain.class);
        for (Train trains : newTimeTable.getTrains())
            System.out.println(trains);
        System.out.println("---------------------------");

       // parserXML.saveObject(newTimeTable);

        String timeAfter = "18:00";
        System.out.println(" Trains after " + timeAfter);
        List<Train> byDate = parserXML.parsByTime(timeAfter);
        byDate.forEach((d) -> {
            System.out.println(d.toString());
        });
        TimeTableTrain new1TimeTable = new TimeTableTrain();
        new1TimeTable.setTrains(byDate);
        parserXML.saveObject(new1TimeTable);
    }
}
