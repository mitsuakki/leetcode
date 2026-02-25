// // Vec<i32> = [x1, x2, x3, ..., xN]
// //       │
// //       ├─> Chunk 1 -> Thread 1 -> lookup table -> bit counts
// //       ├─> Chunk 2 -> Thread 2 -> lookup table -> bit counts
// //       └─> Chunk 3 -> Thread 3 -> lookup table -> bit counts
// // Merge all chunks → sorted / processed vector

impl Solution {
    fn generate_lookup_table() -> [u8; 256] {
        let mut table = [0u8; 256];

        for i in 0..256 {
            table[i] = table[i >> 1] + (i & 1) as u8
        }

        table
    }

    pub fn sort_by_bits(arr: Vec<i32>) -> Vec<i32> {
        let lookup_table = Self::generate_lookup_table();
        let mut buckets = vec![Vec::new(); 33];

        for &num in &arr {
            let n = num as u32;
            let bits = lookup_table[(n & 0xFF) as usize]
                    + lookup_table[((n >> 8) & 0xFF) as usize]
                    + lookup_table[((n >> 16) & 0xFF) as usize]
                    + lookup_table[((n >> 24) & 0xFF) as usize];
            
            buckets[bits as usize].push(num);
        }

        for bucket in &mut buckets {
            bucket.sort_unstable();
        }

        buckets.into_iter().flatten().collect()
    }
}
