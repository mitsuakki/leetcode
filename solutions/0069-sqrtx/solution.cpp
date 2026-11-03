class Solution {
public:
    int mySqrt(int x) {
        if (x < 2) return x;

        double y = x / 2.0;
        double x_previous = -1.0;

        for (int i = 0; i < 1000; i++)
        {
            double next = 0.5 * (y + x / y);
            if (next == y || next == x_previous) {
                break;
            }
            x_previous = y;
            y = next;
        }

        long long r = (long long)y;
        while (r * r > x) r--;
        while ((r + 1) * (r + 1) <= x) r++;
        return (int)r;
    }
};
