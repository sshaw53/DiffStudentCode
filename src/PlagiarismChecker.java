/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author SIERRA SHAW
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     *
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    // Challenge 1: Finding the longest String
    public static int longestSharedSubstring(String doc1, String doc2) {

        int doc1Len = doc1.length();
        int doc2Len = doc2.length();

        String[][] longestTo = new String[doc1Len + 1][doc2Len + 1];

        // Fill first row and column with an empty string
        for (int i = 0; i <= doc1Len; i++) {
            longestTo[i][0] = "";
        }
        for (int j = 0; j <= doc2Len; j++) {
            longestTo[0][j] = "";
        }

        // For every letter in each word
        for (int i = 1; i <= doc1Len; i++) {
            for (int j = 1; j <= doc2Len; j++) {
                // If the letters are equal, add the current letter to the string of the diagonal corner
                // If not, the current string is equal to the string with larger length between the one above and the one to the left
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    longestTo[i][j] = longestTo[i - 1][j - 1] + doc1.charAt(i - 1);
                } else {
                    if (longestTo[i][j - 1].length() > longestTo[i - 1][j].length()) {
                        longestTo[i][j] = longestTo[i][j - 1];
                    } else {
                        longestTo[i][j] = longestTo[i - 1][j];
                    }
                }
            }
        }
        return longestTo[doc1Len][doc2Len].length();
    }



/*
    // Normal pset: Finding the length of the longest substring
    public static int longestSharedSubstring(String doc1, String doc2) {

        int doc1Len = doc1.length();
        int doc2Len = doc2.length();

        int[][] longestTo = new int[doc1Len + 1][doc2Len + 1];

        // For every letter in each word
        for (int i = 1; i <= doc1Len; i++) {
            for (int j = 1; j <= doc2Len; j++) {
                // If the letters are equal, add 1 to the value of the diagonal corner
                //If not, the current value is equal to the larger value between the one above and the one to the left
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    longestTo[i][j] = 1 + longestTo[i - 1][j - 1];
                }
                else {
                    longestTo[i][j] = Math.max(longestTo[i][j - 1], longestTo[i - 1][j]);
                }
            }
        }

        return longestTo[doc1Len][doc2Len];
    }
*/
}