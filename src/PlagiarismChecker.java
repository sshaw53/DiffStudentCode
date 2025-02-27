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
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        int doc1Len = doc1.length();
        int doc2Len = doc2.length();

        int[][] longestTo = new int[doc1Len][doc2Len];

        for (int i = 0; i < doc1Len; i++) {
            for (int j = 0; j < doc2Len; j++) {
                if (doc1.charAt(i) == doc2.charAt(j) && i > 0 && j > 0) {
                    longestTo[i][j] = 1 + longestTo[i - 1][j - 1];
                }
                else if (doc1.charAt(i) == doc2.charAt(j)) {
                    longestTo[i][j] = 1;
                }
                else {
                    if (i == 0 && j == 0) {
                        longestTo[i][j] = 0;
                    }
                    else if (i > 0 && j == 0) {
                        longestTo[i][j] = longestTo[i - 1][j]
;                    }
                    else if (i == 0 && j > 0) {
                        longestTo[i][j] = longestTo[i][j - 1];
                    }
                    else {
                        longestTo[i][j] = Math.max(longestTo[i][j - 1], longestTo[i - 1][j]);
                    }
                }
            }
        }

        return longestTo[doc1Len - 1][doc2Len - 1];
    }
}
