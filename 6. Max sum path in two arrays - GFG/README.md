# 6. Max sum path in two arrays
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given two sorted arrays A and B&nbsp;of size M and N respectively. Each array&nbsp;may have some elements in common with the other array. Find the maximum&nbsp;sum of a&nbsp;path&nbsp;from the beginning of any array to the end of any of the two arrays. We can switch from one array to another array only at the common elements.Both the arrays are sorted.<br>
Note: Only one repeated value is considered in the&nbsp;valid path sum.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>M = 5, N = 4
A[] = {2,3,7,10,12}
B[] = {1,5,7,8}
<strong>Output: </strong>35<strong>
Explanation: </strong>The path will be 1+5+7+10+12
= 35.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>M = 3, N = 3
A[] = {1,2,3}
B[] = {3,4,5}
<strong>Output: </strong>15<strong>
Explanation: </strong>The path will be 1+2+3+4+5=15.</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything.&nbsp;Complete the function <strong>max_path_sum()</strong> which takes the two arrays A and B along with their sizes M and N as input parameters. It returns the maximum path sum.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(M + N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><br>
<span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= M,N &lt;= 10<sup>4</sup><br>
1 &lt;= A[i], B[i] &lt;= 10<sup>4</sup></span></p>
 <p></p>
            </div>