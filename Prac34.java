// Equal Sum Arrays With Minimum Number of Operations

class Solution {
    int result = 0;
    int total1;
    int total2;
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) {
            return 0;
        }
        if(nums1 == null || nums2 == null) {
            return -1;
        }
        int min1 = nums1.length * 1;
        int min2 = nums2.length * 1;
        
        int max1 = nums1.length * 6;
        int max2 = nums2.length * 6;
        
        if(min1 > max2) {
            return -1;
        }
        if(min2 > max1) {
            return -1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        total1 = 0;
        total2 = 0;
        for(int i : nums1) {
            total1 += i;
        }
        
        for(int i : nums2) {
            total2 += i;
        }
        
        if(total1 == total2) {
            return 0;
        }
        
        if(total1 < total2) {
            helper(nums1, nums2);
            System.out.println("Hello");
        } else {
            int temp = total1;
            total1 = total2;
            total2 = temp;
            helper(nums2, nums1);
            //System.out.println("WOrld");
        }
        return result;
    }
    
    private void helper(int[] arr1, int[] arr2) {
        int pointer1 = 0;
        int pointer2 = arr2.length-1;
        boolean flag1 = false;
        boolean flag2 = false;
        while(total1 < total2) {
            if(flag1 == true || (arr2[pointer2] - 1 > 6 - arr1[pointer1] || flag1 == true)) {
                //arr2[pointer2] = 1;
                total2 = total2 - arr2[pointer2]  + 1;
                result++;
                pointer2--;
                if(pointer2 == -1) {
                    flag2 = true;
                }
            }  else {
                //arr1[pointer1] = 6;
                total1 = total1 - arr1[pointer1] + 6;
                result++;
                pointer1++;
                if(pointer1 == arr1.length) {
                    flag1 = true;
                }
            }
        }
    }
}