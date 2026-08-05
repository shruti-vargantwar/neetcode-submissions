class TimeStampedValue {
    public int timestamp;
    public String value;

    public TimeStampedValue(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    public Map<String, ArrayList<TimeStampedValue>> entriesByKey;

    public TimeMap() {
        this.entriesByKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!this.entriesByKey.containsKey(key)) {
            this.entriesByKey.put(key, new ArrayList());
        }

        this.entriesByKey.get(key).add(new TimeStampedValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!this.entriesByKey.containsKey(key)) {
            return "";
        }

        ArrayList<TimeStampedValue> list = this.entriesByKey.get(key);
        Optional<TimeStampedValue> matchedResultOptional = binarySearchTime(list, timestamp);
        if (matchedResultOptional.isEmpty()) {
            return "";
        }

        return matchedResultOptional.get().value;
    }

    private Optional<TimeStampedValue> binarySearchTime(
        ArrayList<TimeStampedValue> list, int target) {
        int start = 0, end = list.size() - 1;
        int matchedIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            TimeStampedValue midTimestamp = list.get(mid);
            if (midTimestamp.timestamp <= target) {
                matchedIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (matchedIndex == -1) {
            return Optional.empty();
        }

        return Optional.of(list.get(matchedIndex));
    }
}
