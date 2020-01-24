public class Tortoise {
    public static int[] race(int v1, int v2, int g) {

        //had to give up on this one due to rounding problems.
        //IMO the tester did not

        if (v1 >= v2) return null;

        double hours = (double)g/(double)(v2 - v1);//this equation gets the time to catchup in hours
        double minutes = 60*(hours - Math.floor(hours));
        double seconds = 60*(minutes - Math.floor(minutes));

        int[] catchUpTime = {(int)Math.floor(hours), (int)Math.floor(minutes), (int)Math.round(seconds)};
        return catchUpTime;
    }
}