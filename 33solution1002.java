class Solution {
    public List<String> commonChars(String[] words) {

        List<String> ans = new ArrayList<>();

        int[] min = new int[26];
        Arrays.fill(min, 100);

        for (String word : words) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                min[i] = Math.min(min[i], count[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (min[i] > 0) {
                ans.add("" + (char)(i + 'a'));
                min[i]--;
            }
        }

        return ans;
    }
}