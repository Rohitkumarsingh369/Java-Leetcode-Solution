# 14. Minimum number of jumps
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element).&nbsp;If an element is <strong>0</strong>, then cannot move through that element.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 11
a[] = {1,3,5,8,9,2,6,7,6,8,9}
<strong>Output: </strong>3<strong>
Explanation: </strong>First jump from 1st element,
and we jump to 2nd element with value 3.
Now, from here we jump to 5h element with
value 9. and from here we will jump to
last.</span>
</pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>N = 6
a[] = {1,4,3,2,6,7}
<strong>Output: </strong>2</span></pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Complete the function&nbsp;<strong>minimumJump()</strong>&nbsp;which takes an array and N (number of elements) as input parameters&nbsp;and returns the answer(if no answer possible return -1)</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity</strong> : O(N)<br>
<strong>Expected Auxiliary Space</strong>: O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤ 10<sup>5</sup><br>
0 &lt;= a<sub>i</sub> &lt;= 10<sup>5</sup></span></p>
 <p></p>
            </div>