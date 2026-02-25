impl Solution {
    pub fn my_sqrt(x: i32) -> i32 {
        if x == 0 { return 0; }

        let x = x as f64;
        let mut x0 = x / 2.0;
        let accuracy = 0.0001;
        let mut diff = f64::MAX;

        while diff > accuracy {
            let x1 = 0.5 * (x0 + x / x0);
            diff = (x0 - x1).abs();
            x0 = x1;
        }

        x0.floor() as i32
    }
}
