impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        let mut op = x as i64;   // work with 64-bit to avoid overflow
        let mut res = 0i64;

        // "one" starts at the highest power of 4 <= x
        // don't try to change it or u'll definitly gonna break sthg
        let mut one = 1i64;
        while one <= op {
            one <<= 2;
        }
        one >>= 2;

        while one != 0 {
            let candidate = res + one;
            if op >= candidate {
                op -= candidate;
                res = (res >> 1) + one;
            } else {
                res >>= 1;
            }
            one >>= 2;
        }
        res as i32
    }
}
