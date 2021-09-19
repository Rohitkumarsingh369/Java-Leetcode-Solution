class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         double[] arr = new double[nums1.length + nums2.length];
        
        for (int j=0; j<nums1.length; j++) {
                arr[j] = nums1[j];
        }
        for (int k=0; k<nums2.length; k++) {
                arr[nums1.length+k] = nums2[k];
        }
        
        Arrays.sort(arr);
        
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end-start)/2;
        if (arr.length%2==1) {
            return arr[mid];
        }
        else {
            double med = (arr[mid] + arr[mid+1])/2;
            return med;
        }
    }
}