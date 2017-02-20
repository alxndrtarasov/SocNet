import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Parser parser = new Parser("C:/Users/alta0816/Downloads/Anc");
        parser.parseStudents();
    }
}
