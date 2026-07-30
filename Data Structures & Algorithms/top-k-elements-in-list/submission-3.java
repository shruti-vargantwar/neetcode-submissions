/**
Approach:
We create a frequency map: how many times a word has occurred.
Then create a bounded min heap of size k using PriorityQueue. As we keep pushing the elements,
elements get reordered based on the frequency of the number. Heap can only keep K elelements. Before
pushing k+1 th element, pop the top of the heap. This will make sure the the number with minim freq
at that stage will get kicked out.

TC: n log k
SC: O(n)
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> heap =
            new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));

        for (int num : map.keySet()) { // critical step: iterate through map's keySet
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Put k elements in the result array
        int index = 0;
        while (!heap.isEmpty()) {
            result[index] = heap.poll();
            index++;
        }

        return result;
    }
}
