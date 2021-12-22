package ua.kiev.prog.exeptions;

public class UserNotFoundException extends Exception {
    public String getMessage() {
        return "User not found";
    }
}
