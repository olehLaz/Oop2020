package ua.homestudents;

public interface GroupDAO {
    public void saveGroup(Group group);

    public Group loadGroupByName(String groupName);
}
