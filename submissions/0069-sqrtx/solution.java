import java.lang.Math;

class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;

        // Exponential identity
        // sqrt(x) = e^(1/2 * ln(x))
        // return (int)Math.exp(0.5 * Math.log(x));

        // Binary Search

        // int left = 1, right = x;
        // int result = 0;

        // while(left <= right) {
        //     int mid = left + (r - left) / 2;

        //     if (mid <= x / mid) {
        //         res = mid;
        //         left = mid + 1;
        //     } else {
        //         right = mid + 1;
        //     }
        // }

        // return result;

        // Binary Numeral System
        int n = x, c = 0, d = 1 << 30;

        while (d > x) {
            d >>= 2;
        }

        while (d != 0) {
            if (n >= c + d) {
                n -= c + d;
                c = (c >> 1) + d;
            } else {
                c >>= 1;
            }

            d >>= 2;
        }

        return c;
    }
}
