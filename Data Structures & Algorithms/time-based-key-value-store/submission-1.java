class TimeValuePair {
    int timestamp;
    String value;

    public TimeValuePair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {
    Map<String, ArrayList<TimeValuePair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList());
        }

        map.get(key).add(new TimeValuePair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<TimeValuePair> list = map.get(key);
        Optional<TimeValuePair> optionalResult = binarySearch(list, timestamp);

        if (optionalResult.isEmpty()) {
            return "";
        }

        return optionalResult.get().value;
    }

    private Optional<TimeValuePair> binarySearch(ArrayList<TimeValuePair> list, int timestamp) {
        int start = 0, end = list.size() - 1;
        int matchedIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            TimeValuePair midPair = list.get(mid);
            if (midPair.timestamp <= timestamp) {
                matchedIndex = mid; // save potential answer because we have no idea if an exact
                                    // matching timestamp is present in the arraylist
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
