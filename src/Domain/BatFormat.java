package Domain;

public class BatFormat {

    private static final String db2 = "db2cmd db2 -tvf workingdirectory\\filename\n" +
            "@echo off\n" +
            "echo ------------------------------\n" +
            "echo New Student Database Installed\n" +
            "echo ------------------------------\n" +
            "exit";

    private static final String mySQL = "C:\\xampp\\mysql\\bin\\mysql.exe -u root -p < filename";

    public static String getDb2() {
        return db2;
    }

    public static String getMySQL() {
        return mySQL;
    }
}
