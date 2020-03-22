package hibernate.manytomany.facade;

public class EntitiesFacadeException extends Exception {
    public static String ERR_SEARCHEMPLOYEE_ERROR = "Cannot search employee";
    public static String ERR_SEARCHCOMPANY_ERROR = "Cannot search company";

    public EntitiesFacadeException(String message) {
        super(message);
    }
}