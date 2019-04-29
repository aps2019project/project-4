package Model;

public class Constants {
    private static Constants constants;
    private final int INITIAL_MANAS;
    private final int INITIAL_DARICS;

    private Constants() {
        INITIAL_MANAS = 5;
        INITIAL_DARICS = 15000;
    }

    public static Constants getInstance() {
        if (constants == null)
            constants = new Constants();
        return constants;
    }
}
