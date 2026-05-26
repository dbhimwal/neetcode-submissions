class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> collections = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            String base = getBase(strs[i]);
            if (collections.containsKey(base)) {
                collections.get(base).add(strs[i]);
            } else {
                List<String> value = new ArrayList<>();
                value.add(strs[i]);
                collections.put(base, value);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (Map.Entry<String, List<String>> collection : collections.entrySet()) {
            result.add(collection.getValue());
        }
        return result;
    }

    private String getBase(String s) {
        char[] character = s.toCharArray();
        Arrays.sort(character);
        return new String(character);
    }
}
