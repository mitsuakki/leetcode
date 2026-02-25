impl Solution {
    pub fn fizz_buzz(n: i32) -> Vec<String> {
        (1..=n).map(|n| {
            let mut curr = String::new();
            let mod3 = n % 3 == 0;
            let mod5 = n % 5 == 0;
            if mod3 { curr += "Fizz" }
            if mod5 { curr += "Buzz" }
            if curr.len() == 0 { n.to_string() } else { curr }
        }).collect()
    }
}
