import com.kamitbrains.nkaurelien.ionis_stm.csvreader.Csv;

public class Main {
    public static void main(String[] args) {


        Csv reader = new Csv("assets\\test_1.csv");

        System.out.println(reader);
        System.out.println(reader.getHeader());
        System.out.println(reader.getRows());

    }
}