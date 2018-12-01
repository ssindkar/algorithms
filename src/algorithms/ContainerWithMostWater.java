package algorithms;

import static java.lang.String.format;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 5, 1, 3};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int result = containerWithMostWater.maxArea(input);
        System.out.println(format("area is %d", result));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0, temp = 0;
        while (left < right) {
            if (height[left] > height[right]) {
                temp = (right - left) * height[right];
                right--;
            } else {
                temp = (right - left) * height[left];
                left++;
            }
            max = max > temp ? max : temp;
        }
        return max;
    }
}
