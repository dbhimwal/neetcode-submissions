class TimeMap {
    private class TimestampValue {
        int timestamp;
        String value;

        public TimestampValue(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    Map<String, List<TimestampValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TimestampValue timeValue = new TimestampValue(value, timestamp);
        if(map.containsKey(key)) {
            map.get(key).add(timeValue);
        } else {
            List<TimestampValue> valueList = new ArrayList<>();
            valueList.add(timeValue);
            map.put(key, valueList);
        }
    }
    
    public String get(String key, int timestamp) {
        List<TimestampValue> valueList = map.getOrDefault(key, new ArrayList<>());
        if (valueList.size() == 0) {
            return "";
        } else {
            return search(valueList, timestamp, 0, valueList.size());
        }
    }

    private String search(List<TimestampValue> valueList, int timestamp, int l, int r) {
        if (r - 1 <= l) {
            if(valueList.get(l).timestamp > timestamp) {
                return "";
            }
            return valueList.get(l).value;
        }
        int mid = l + (r - l)/2;
        if(valueList.get(mid).timestamp == timestamp) {
            return valueList.get(mid).value;
        } else if (valueList.get(mid).timestamp > timestamp) {
            return search(valueList, timestamp, 0, mid);
        } else {
            return search(valueList, timestamp, mid, r);
        }
    }
}
