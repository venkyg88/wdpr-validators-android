package com.disney.android.wdprvalidators;

/**
 * Created by venkatgonuguntala on 2/6/16.
 */
public class Point {
    int X;
    int Y;
    public Point(){}
    public Point( int x, int y){
        this.X = x;
        this.Y = y;
    }
    public static boolean isPointInPolygon(Point[] polygon, Point point)
    {
        boolean isInside = false;
        for (int i = 0, j = polygon.length - 1; i < polygon.length; j = i++)
        {
            if (((polygon[i].Y > point.Y) != (polygon[j].Y > point.Y)) && (point.X < (polygon[j].X - polygon[i].X) * (point.Y - polygon[i].Y) / (polygon[j].Y - polygon[i].Y) + polygon[i].X))
            {
                isInside = !isInside;
            }
        }
        return isInside;
    }
}
