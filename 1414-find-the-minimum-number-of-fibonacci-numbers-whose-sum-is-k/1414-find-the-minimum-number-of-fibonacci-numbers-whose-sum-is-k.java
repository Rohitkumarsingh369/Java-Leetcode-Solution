class Solution {
    public int findMinFibonacciNumbers(int k) {
        int result = 0;
    int sum = 0;
    int i = 2;
    int[] arr = new int[46];
    
    arr[0] = 1;
    arr[1] = 1;
    
    while(arr[i-2] + arr[i -1] <= k) {
        arr[i] = arr[i-2] + arr[i-1];
        i++;
    }
    
    for(int j = i - 1; j >= 0 && sum < k; j--) {
        if(sum + arr[j] <= k) {
            sum += arr[j];
            result++;
        }
    }
    
    return result;
    }
}