class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs) {
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++) {
                int ascii = (int)chars[i];
                String ascii_string;
                if(ascii < 10) {
                    ascii_string = "00" + ascii;
                } else if (ascii < 100) {
                    ascii_string = "0" + ascii;
                } else {
                    ascii_string = Integer.toString(ascii);
                }
                result += ascii_string;
            }
            result += "b";
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String currentString = "";
        for (int i = 0; i < str.length(); ) {
            if(str.charAt(i) == 'b') {
                result.add(currentString);
                currentString = "";
                i++;
                continue;
            } else {
                String character = str.substring(i, i+3);
                int ascii = Integer.parseInt(character);
                char current = (char) ascii;
                currentString += current;
                i = i+3;
            }
        }
        return result;
    }
}
