package calabreso.corp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {

        List<Grow> grows = new ArrayList<>();
        grows.add(new Grow(6, "Grow 40x40", 300.50));
        grows.add(new Grow(10, "Grow 60x60", 350.00));
        grows.add(new Grow(20, "Grow 80x80", 545.00));
        grows.add(new Grow(0, "Grow 120x120", 600.00));

        Iterator<Grow> growIterator = grows.iterator();
        while (growIterator.hasNext()){
            Grow grow = growIterator.next();
            if (grow.getQuantidade() == 0){
                growIterator.remove();
            }
        }

        grows.removeIf(grow -> grow.getQuantidade() == 0);
        System.out.println(grows);
    }
}
