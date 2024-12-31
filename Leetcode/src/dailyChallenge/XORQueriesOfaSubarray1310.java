/**
 * 
 */
package LeetCode;

public class XORQueriesOfaSubarray1310 {
	public int[] xorQueries(int[] arr, int[][] queries) {

		int[] xor1 = new int[arr.length];

		xor1[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {

			xor1[i] = xor1[i - 1] ^ arr[i];
		}

		int[] xor2 = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {

			xor2[i] = xor1[queries[i][0]] ^ xor1[queries[i][1]];
		}

		return xor2;
	}

}
