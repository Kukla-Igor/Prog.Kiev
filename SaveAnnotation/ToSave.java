public class ToSave {
    private int num = 55;
    @Save
    private int numToSave = 4545;
    private String text = "Test";
    @Save
    private String textToSave = "SaveTest";

    public ToSave() {
    }

    @Override
    public String toString() {
        return "ToSave{" +
                "num=" + num +
                ", numToSave=" + numToSave +
                ", text='" + text + '\'' +
                ", textToSave='" + textToSave + '\'' +
                '}';
    }
}
