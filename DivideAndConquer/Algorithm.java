import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

/**
 * Algorithm
 */
public class Algorithm {

    private List<Point> points;

    public Algorithm(List<Point> points) {
        this.points = points;
    }

    public double solveProblem() {
        List<Point> sortedXPoints = new ArrayList<>();
        List<Point> sortedYPoints = new ArrayList<>();

        for (Point p : this.points) {
            sortedXPoints.add(p);
            sortedYPoints.add(p);
        }

        // we have to sort the items (points) based on X and Y
        Collections.sort(sortedXPoints, new XSorter());
        Collections.sort(sortedYPoints, new YSorter());

        return findClosestPoint(sortedXPoints, sortedYPoints, sortedXPoints.size());

    }

    private double findClosestPoint(List<Point> sortedXPoints, List<Point> sortedYPoints, int numOfPoints) {

        if (numOfPoints <= 3)
            return bruteForceSearch(sortedXPoints);

        int middleIndex = numOfPoints / 2;

        Point middlePoint = sortedXPoints.get(middleIndex);

        // DIVIDE PHASE - we keep dividing the dataset into left and right sub-arrays
        List<Point> leftSubPointsSortedX = new ArrayList<>();
        List<Point> rightSubPointsSortedX = new ArrayList<>();

        for (int index = 0; index < numOfPoints; index++) {
            if (sortedXPoints.get(index).getX() <= middlePoint.getX()) {
                leftSubPointsSortedX.add(sortedXPoints.get(index));
            } else {
                rightSubPointsSortedX.add(sortedXPoints.get(index));
            }

        }

        // then we have to find the CPP in the left and right sub-array
        double deltaLeft = findClosestPoint(leftSubPointsSortedX, sortedYPoints, middleIndex);
        double deltaRight = findClosestPoint(rightSubPointsSortedX, sortedYPoints, numOfPoints - middleIndex);

        double delta = Math.min(deltaLeft, deltaRight);

        List<Point> pointsInStrip = new ArrayList<>();

        // linear search for the items that fall within the strip [middleItem.x-delta,
        // middleItem.x+delta]
        for (int i = 0; i < numOfPoints; i++) {
            if (Math.abs(sortedYPoints.get(i).getX() - middlePoint.getX()) < delta) {
                pointsInStrip.add(sortedYPoints.get(i));
            }
        }

        double minDistanceStrip = findMinimimDistanceStrip(pointsInStrip, delta);

        return Math.min(delta, minDistanceStrip);
    }

    private double findMinimimDistanceStrip(List<Point> points, double delta) {
        double minDistance = delta;
        // this is a O(N) running time
        for (int i = 0; i < points.size(); i++) {
            // it will have a constant running time (at almost 16 iterations)
            for (int j = i + 1; j < points.size() && (points.get(j).getY() - points.get(i).getY()) < minDistance; j++) {
                minDistance = distance(points.get(i), points.get(j));

            }
        }

        return minDistance;
    }

    private double bruteForceSearch(List<Point> points) {
        // this approatch has O(N*N) running time
        // we want to check the distance between the points just once
        // d(a, b) = d(b, a)
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = 1 + i; j < points.size(); j++) {
                double actual_distance = distance(points.get(i), points.get(j));
                if (actual_distance < minDistance) {
                    minDistance = actual_distance;
                }

            }
        }

        return minDistance;

    }

    private double distance(Point point1, Point point2) {
        double xDistance = point1.getX() - point2.getX();
        double yDistance = point1.getY() - point2.getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

}
