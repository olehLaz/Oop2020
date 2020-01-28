package ua.homestudents;

public class GroupController {
    private GroupDAO groupDAO;

    public GroupController(GroupDAO groupDAO) {
        super();
        this.groupDAO = groupDAO;
    }

    public GroupController() {
        super();
    }

    public GroupDAO getGroupDAO() {
        return groupDAO;
    }

    public void setGroupDAO(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public Group loadGroupByName(String groupName) {
        if (groupDAO == null) {
            throw new IllegalArgumentException("Null GroupDAO realisation");
        }
        return groupDAO.loadGroupByName(groupName);
    }

    public void saveGroup(Group group) {
        if (groupDAO == null) {
            throw new IllegalArgumentException("Null GroupDAO realisation");
        }
        groupDAO.saveGroup(group);
    }
}
