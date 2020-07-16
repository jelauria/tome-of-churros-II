import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a list of Strings and a target character, return the largest sub-list of Strings
sharing the same frequency of the target character, ignoring case.

Example:
Input: {apple, orange, bannana, a, Android, purple, America, Amazon}
       target = ‘a’
Output: {apple, orange, a, Android}

Client would call groupFinder(target, input);
*/

public class Solution {
    public List<String> groupFinder(char target, List<String> data) {
        Map<Integer, List<String>> groups = new HashMap<>();
        for(String s : data) {
            Integer key = this.getKey(target, s);
            if (!groups.containsKey(key)) {
                groups.put(key, new LinkedList<>());
            }
            groups.get(key).add(s);
        }
        int max = 0;
        List<String> result = null;
        for (Integer key : groups.keySet()) {
            List<String> group = groups.get(key);
            if (group.size() > max) {
                max = group.size();
                result = group;
            }
        }
        return result;
    }
    private int getKey(char target, String data) {
        int counter = 0;
        for (int i = 0; i < data.length(); i++) {
            if (Character.toLowerCase(data.charAt(i)) == Character.toLowerCase(target)) {
                counter++;
            }
        }
        return counter;
    }
}
