import java.util.Comparator;

/**
 * XSorter
 */
public class XSorter implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Double.compare(o1.getX(), o2.getX());
    }

}
