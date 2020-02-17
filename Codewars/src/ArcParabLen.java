public class ArcParabLen {

    final static double decf = 1000000000;

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

        length = Math.round(length * decf) / decf;

        return length;
    }
}
