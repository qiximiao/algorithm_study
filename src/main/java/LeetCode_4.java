import org.junit.Test;

/**
 * @Auther: qiximiao
 * @Date: 2018/12/4
 */
public class LeetCode_4 {
    @Test
    public void test() {
        int[] nums1 = {2};
        int[] nums2 = {1, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    //实际运行结果证明,该方法的速度和官方一致,但是复杂度是O(n/2),远离是组成一个新的数组,记录从小到大的数组,不符合官方
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //判断数量偶数,奇数,判断找第几大的数
        //需要的下标
        //记录nums1的下标,nums2的下标
        int len1 = nums1.length;
        int len2 = nums2.length;
        int midIndex = (len1 + len2) / 2;//结果对于单数的是ok的,对双的需要另外取midIndex-1的值
        int[] arr = new int[midIndex + 1];//[midIndex]的值
        int dx1 = 0;
        int dx2 = 0;
        for (int i = 0; i <= midIndex; i++) {
            if (len1 != 0 && dx1 < len1) {
                if (len2 != 0 && dx2 < len2) {
                    if (nums1[dx1] > nums2[dx2]) {
                        arr[i] = nums2[dx2++];
                    } else {
                        arr[i] = nums1[dx1++];
                    }
                } else {
                    arr[i] = nums1[dx1++];
                }
            } else {
                arr[i] = nums2[dx2++];
            }
        }
        if (1 == (len1 + len2) % 2) {
            return arr[midIndex];
        } else {
            return (arr[midIndex] + arr[midIndex - 1]) / 2.0;
        }
    }

    //官方的方法,看说明就头疼,看这种无意义的代码更头疼,不解释了,放弃了
    public double findMedianSortedArrays1(int[] A, int[] B) {
        if (A.length > B.length) { // to ensure m<=n,使得前短后长,这样判断的组合会减少
            int[] temp = A;
            A = B;
            B = temp;//交换数组
        }
        int m = A.length;//长度m
        int n = B.length;//长度n

        int iMin = 0,
            iMax = m,
            halfLen = (m + n + 1) / 2;//中长

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
