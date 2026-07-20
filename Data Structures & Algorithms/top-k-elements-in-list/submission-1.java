/*
TC: O(n + m log k), where m = distinct elements → O(n log k) worst case
SC: O(m + k) → O(n) worst case

Building the frequency map takes O(n) since we scan every element once. We then push each of the m
distinct numbers through a heap capped at size k, and each push/pop costs O(log k), giving O(m log
k) — worst case O(n log k) when all elements are distinct. Space is O(m) for the map plus O(k) for
the heap, which simplifies to O(n).
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>(); // <Number, its frequency>
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap =
            new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b))); // minHeap

        for (int num : map.keySet()) { // iterate throught map's keySet (not the input nums)
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int index = 0;
        while (!heap.isEmpty()) {
            result[index] = heap.poll();
            index++;
        }

        return result;
    }
}
