class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int answer = 1;
        int maxSpeed = Arrays.stream(piles).max().getAsInt();
        int start = 1, end = maxSpeed;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int totalHours = calculateTotalHours(piles, mid);
            if (totalHours <= h) {
                answer = mid; // potential answer
                end = mid - 1;
            } else {
                start = mid + 1; // too slow
            }
        }

        return answer;
    }

    private int calculateTotalHours(int[] piles, int speed) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (int) Math.ceil((double) pile / speed);
        }
        return totalHours;
    }
}
