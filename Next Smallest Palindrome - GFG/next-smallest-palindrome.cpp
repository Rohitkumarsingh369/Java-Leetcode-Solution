//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

// } Driver Code Ends
//User function template for C++
class Solution{
public:
vector<int> generateNextPalindrome(int a[], int n) {
    bool isGreater = false;
    vector<int> ans(n, 0);
   
    int i=0;
    int j = n-1;
    
    // For Even Length of Array
    if(n%2 == 0)
    {
        while(i < j)
        {
            if(a[i] > a[j] || (a[i] >= a[j] && isGreater))
            {
                isGreater = true;
            }
            else
            {
                isGreater = false;
            }
            
            // Changing the values in vector<int> ans;
            ans[i] = a[i];
            ans[j] = ans[i];  
            
            i++;
            j--;
        }
    }
    // For Odd Length of Array
    else
    {
        while(i <= j)
        {
            if(a[i] > a[j] || (a[i] >= a[j] && isGreater))
            {
                isGreater = true;
            }
            else
            {
                isGreater = false;
            }
            
            // Changing the values in vector<int> ans;
            ans[i] = a[i];
            ans[j] = ans[i];  
            
            i++;
            j--;
        }
        
    }
    
    // If the value we got is less than the originaly array of nums
    if(isGreater == false)
    {
        i--;
        j++;
        // If the number is 9 making it zero
        if(ans[i] == 9)
        {
            ans[i] = 0;
            ans[j] = 0;
            
            i--;
            j++;
            
            // Marking all the numbers with 9 as 0
            while(ans[i] == 9 && i >= 0 && j < n)
            {
                ans[i] = 0;
                ans[j] = 0;
                i--;
                j++;
            }
        }
        
        // increasing the number by 1 and assigning it to both position at pos i and j
        if(i >=0 && j < n)
        {
            
            ans[i] = ans[i]+1;
            ans[j] = ans[i];
            isGreater = true;
            
        }
 
    }
    
    /* if still false, that means all the numbers were 9 insert 1 at end 
    and make first positio vector<int> ans as 1 */
    if(isGreater == false)
    {
        ans.push_back(1);
        ans[0] = 1;
    }
 
   
    return ans;
}
 
};

//{ Driver Code Starts.


int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int num[n];
        for (int i = 0; i < n; i++) {
            cin >> num[i];
        }
        Solution ob;
        auto ans = ob.generateNextPalindrome(num, n);
        for (auto x : ans) {
            cout << x << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends