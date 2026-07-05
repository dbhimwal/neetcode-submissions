class Solution {
    List<String> response;
    public List<String> restoreIpAddresses(String s) {
        response = new ArrayList<>();
        restoreIpAddressesHelper(s, 0, new ArrayList<>());
        return response;
    }

    private void restoreIpAddressesHelper(String s, int start, List<Integer> result) {
        if(start == s.length()) {
            if(result.size() == 4) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    if (i > 0) sb.append('.');
                    sb.append(result.get(i));
                }

                response.add(sb.toString());
                return;
            }
        }
        if(result.size() > 4) {
            return;
        }

        int number = 0;
        for(int i = start; i < s.length(); i++) {
            if((s.charAt(start) == '0') && i != start) {
                break;
            }

            number = 10*number + (s.charAt(i) - '0');
            if(number < 256) {
                result.add(number);
                restoreIpAddressesHelper(s, i + 1, result);
                result.remove(result.size() - 1);
            } else {
                break;
            }
        }
    }
}