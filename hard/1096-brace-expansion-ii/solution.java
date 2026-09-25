class Solution {
    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);
        
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            Set<String> cur;

            if (s.charAt(i) == '{') {
                i++; // skip '{'
                cur = parse(s);
                i++; // skip '}'
            }
            else if (s.charAt(i) == ',') {
                i++; // skip ','
                cur = parse(s);

                // Union
                result.addAll(cur);
                return result;
            }
            else {
                // lowercase letter
                cur = new HashSet<>();
                cur.add(String.valueOf(s.charAt(i)));
                i++;
            }

            // Concatenation
            result = multiply(result, cur);
        }

        return result;
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}