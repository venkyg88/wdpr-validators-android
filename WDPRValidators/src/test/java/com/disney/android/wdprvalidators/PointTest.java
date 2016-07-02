package com.disney.android.wdprvalidators;

import junit.framework.TestCase;

/**
 * Created by venkatgonuguntala on 2/6/16.
 */
public class PointTest extends TestCase {
    private Point point;
    private Point[] point1;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        point = new Point(5,5);
        point1 = new Point[]{new Point(0,0), new Point(0,10), new Point(10,10), new Point(10, 0)};
    }

    public void testForPolygon(){
        assertEquals(true, Point.isPointInPolygon(point1, point));
    }

    public void testForNotInPolygon() {
        Point point2 = new Point(-1,-1);
        assertEquals(false, Point.isPointInPolygon(point1, point2));
    }

    public void testForPolygonWithTenCordinates(){
        Point pointOutside = new Point(5,-1);
        Point pointOutside1 = new Point(9,7);
        Point pointOutside2 = new Point(2,6);
        Point pointInside = new Point(7,2);
        Point pointInside1 = new Point(4,4);
        Point pointInside11 = new Point(8,4);

        Point[] polygon = new Point[]{new Point(1,2), new Point(5,1), new Point(8,1), new Point(11,3), new Point(4,9), new Point(3,4)};
        assertEquals(false, Point.isPointInPolygon(polygon, pointOutside));
        assertEquals(false, Point.isPointInPolygon(polygon, pointOutside1));
        assertEquals(false, Point.isPointInPolygon(polygon, pointOutside2));
        assertEquals(true, Point.isPointInPolygon(polygon, pointInside));
        assertEquals(true, Point.isPointInPolygon(polygon, pointInside1));
        assertEquals(true, Point.isPointInPolygon(polygon, pointInside11));
    }

}
