package ua.homestudents;

import java.io.*;

public class GroupDAOSerializableImplementation implements GroupDAO {
    private File casheFolder;

    public GroupDAOSerializableImplementation(File casheFolder) {
        super();
        this.casheFolder = casheFolder;
    }

    public GroupDAOSerializableImplementation() {
        super();
    }

    @Override
    public void saveGroup(Group group) {
        File file = new File(casheFolder, group.getGroupName() + ".pn");
        try (ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(group);
        } catch (IOException e) {
        }
    }

    @Override
    public Group loadGroupByName(String groupName) {
        File file = new File(casheFolder, groupName + ".pn");
        try (ObjectInput ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Group) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
