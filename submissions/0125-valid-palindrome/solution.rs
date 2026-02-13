impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let mut iter_front = s.chars()
            .filter(|c| c.is_ascii_alphanumeric())
            .map(|c| c.to_ascii_lowercase());

        let mut iter_back = s.chars()
            .rev()
            .filter(|c| c.is_ascii_alphanumeric())
            .map(|c| c.to_ascii_lowercase());

        iter_front.eq(iter_back)

        // let s: Vec<char> = s.to_lowercase().chars().collect();
        // let (mut p1, mut p2) = (0, s.len().saturating_sub(1));

        // while p1 < p2 {
        //     while p1 < p2 && !s[p1].is_ascii_alphanumeric() { p1 += 1; }
        //     while p1 < p2 && !s[p2].is_ascii_alphanumeric() { p2 -= 1; }
        //     if s[p1] != s[p2] { return false; }
        //     p1 += 1;
        //     p2 -= 1;
        // }

        // true
    }
}
