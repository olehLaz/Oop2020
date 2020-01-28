package ua.comparable1;

public interface CheckedNullforEmployee {
    public int NOT_NULL = 7;

    public static int checkedNullforEmployee(Object a, Object b) {
        if (a == null && b != null) {
            return -1;
        }
        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b == null) {
            return 0;
        }
        return NOT_NULL;
    }
}
