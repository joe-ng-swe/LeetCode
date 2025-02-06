class Solution {
    /**
     * Time complexity = O(n ^ 2)
     * Space complexity = O(1)
     */

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean isPrefixAndSuffix(String str1, String str2) {
        int prefixLength = str1.length();
        int length = str2.length();

        if (length < prefixLength) {
            return false;
        }

        for (int i = 0; i < prefixLength; i++) {
            // Compare each character starting from the left
            if (str2.charAt(i) != str1.charAt(i)) {
                return false;
            }
        }

        for (int i = 0; i < prefixLength; i++) {
            // Compare each character starting from the right
            if (str2.charAt(length - 1 - i) != str1.charAt(prefixLength - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}