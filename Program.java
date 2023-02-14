import java.util.HashSet;
import java.util.Set;

public class Program {

    public static void main(String[] args) {

        Set<Notebook> set = new HashSet<>();
        set.add(new Notebook("Asus", 8, "Windows10", 50000, "Z204"));
        set.add(new Notebook("Lenovo", 16, "Windows11", 34000, "N1213-KJ"));
        set.add(new Notebook("Apple", 32, "MacOS", 135000, "MacBook Pro 13"));
        set.add(new Notebook("HP", 64, "Linux", 90000, "X-103"));
        set.add(new Notebook("Baikal", 4, "dos", 10000, "001"));

        Operations operation = new Operations(set);
        operation.start();
    }
}