package algorithms;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];

        int i = 0, j = 0, x = 0;
        while (j >= k) {
            if (nums1[i] >= nums2[j]) {
                if (res[x] < nums1[i]) {
                    res[x] = nums1[i];
                    i++;
                } else {
                    j++;
                }
            } else if (nums1[i] < nums2[j]) {
                if (res[x] < nums2[j]) {
                    res[x] = nums2[j];
                    j++;
                } else {
                    i++;
                }
            }
        }
        x++;

        while (x < k && i < m && j < n) {
            if (nums1[i] >= nums2[j]) {
                res[++x] = nums1[i++];
            } else {
                res[++x] = nums2[j++];
            }
        }

        if (i == m) {
            while (j < n && x < k) {
                res[x++] = nums2[j++];
            }
        } else {
            while (i < m && x < k) {
                res[x++] = nums1[i++];
            }
        }

        return res;
    }

    public static void main(String args[]) {
        CreateMaximumNumber c = new CreateMaximumNumber();
//        System.out.println(c.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
        System.out.println(c.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 4));
    }
}
