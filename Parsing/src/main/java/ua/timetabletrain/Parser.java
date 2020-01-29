package ua.timetabletrain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private TimeTableTrain timeTableTrain;
    private File file;
    private File tofile;



    public Parser(File file, TimeTableTrain timeTableTrain) {
        this.file = file;
        this.timeTableTrain = timeTableTrain;
    }

    public Parser(File file, File tofile) {
        this.file = file;
        this.tofile = tofile;
    }

    public Object getObject(Class<?> c) {
        Object object = null;
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        return object;
    }

    public void saveObject(TimeTableTrain timeTableTrain) {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(timeTableTrain.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(timeTableTrain, tofile);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

    }

    public List<Train> parsByTime(String after) {
        List<Train> list = new ArrayList<>();

        TimeTableTrain newTimeTable = (TimeTableTrain) getObject(TimeTableTrain.class);
        List<Train> timeTablelist = newTimeTable.getTrains();
        timeTablelist.stream().filter((t)->((t.getDeparture().compareTo(after)>=0))).forEachOrdered((t)->{
            list.add(t);
        });


        return list;
    }


}
