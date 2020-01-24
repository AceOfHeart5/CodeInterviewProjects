public class ArcParabLen {
    /*
    We want to approximate the length of a curve representing a function y = f(x) with a<= x <= b. First, we split
    the interval [a, b] into n sub-intervals with widths h1, h2, ... , hn by defining points x1, x2 , ... , xn-1
    between a and b. This defines points P0, P1, P2, ... , Pn on the curve whose x-coordinates are
    a, x1, x2 , ... , xn-1, b and y-coordinates f(a), f(x1), ..., f(xn-1), f(b) . By connecting these points, we obtain
    a polygonal path approximating the curve.

    Our task is to approximate the length of a parabolic arc representing the curve y = x * x with x in the interval
     [0, 1]. We will take a common step h between the points xi: h1, h2, ... , hn = h = 1/n and we will consider the
      points P0, P1, P2, ... , Pn on the curve. The coordinates of each Pi are (xi, yi = xi * xi).

    The function len_curve (or similar in other languages) takes n as parameter (number of sub-intervals) and returns
    the length of the curve truncated to 9 decimal places.
    */

    public static double lenCurve(int n) {

        // ensure n is valid
        if (n < 1) throw new IllegalStateException("n must be greater than 0!");

        /*
        First we create two arrays of n + 1 points. We need n + 1 because that is the number of points needed to
        store n sub-intervals.
         */
        double[] xVals = new double[n + 1];
        double[] yVals = new double[n + 1];

        /*
        Now, the problem explanation is a little confusing, but it appears that the interval we are always using
        is [0, 1]. And the function of the curve is f(x) = x^2. Given this, we can set all the x and y values of
        our new arrays.
         */
        xVals[0] = 0;
        yVals[0] = 0;
        for (int i = 1; i < xVals.length; i++) {
            xVals[i] = xVals[i - 1] + 1/(double)n;
            yVals[i] = xVals[i] * xVals[i];
        }

        /*
        We now use the distance formula to calculate the distance between each point, and total them
         */
        double length = 0;
        for (int i = 1; i < xVals.length; i++) {
            length += Math.sqrt(Math.pow(xVals[i] - xVals[i - 1], 2) + Math.pow(yVals[i] - yVals[i - 1], 2));
        }

        return length;
    }
}
