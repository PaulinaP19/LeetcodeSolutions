package LeetCode;

import java.util.Arrays;

public class ImageSmoother661 {
	public static int[][] imageSmoother(int[][] img) {
		int[][] sImg = new int[img.length][img[0].length];

		int count = 0;
		int sum = 0;

		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[0].length; j++) {
				sum = img[i][j];
				count += 1;
				if (i - 1 >= 0) {
					sum += img[i - 1][j];
					count += 1;
					if (j - 1 >= 0) {
						sum += img[i - 1][j - 1];
						count += 1;
					}
					if (j + 1 < img[0].length) {
						sum += img[i - 1][j + 1];
						count += 1;
					}
				}
				if (j - 1 >= 0) {
					sum += img[i][j - 1];
					count += 1;
				}
				if (j + 1 < img[0].length) {
					sum += img[i][j + 1];
					count += 1;
				}
				if (i + 1 < img.length) {
					sum += img[i + 1][j];
					count += 1;
					if (j - 1 >= 0) {
						sum += img[i + 1][j - 1];
						count += 1;
					}
					if (j + 1 < img[0].length) {
						sum += img[i + 1][j + 1];
						count += 1;
					}
				}
				System.out.println(sum);
				sImg[i][j] = sum / count;
				count = 0;
			}
		}
		for (int[] a : sImg) {
			System.out.println(Arrays.toString(a));
		}

		return sImg;

	}

	public static void main(String[] args) {

		ImageSmoother661.imageSmoother(new int[][] { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } });
	}
}
