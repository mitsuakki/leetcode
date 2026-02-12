impl Solution {
    pub fn is_palindrome(mut x: i32) -> bool {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if x < 0 || (x % 10 == 0 && x != 0) {
            return false;
        }

        let mut reversed_half = 0;
        while x > reversed_half {
            reversed_half = reversed_half * 10 + x % 10;
            x /= 10;
        }

        // For even length: x == reversed_half
        // For odd length: x == reversed_half / 10 (middle digit ignored)
        x == reversed_half || x == reversed_half / 10
    }
}
