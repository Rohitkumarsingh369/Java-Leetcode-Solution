# Non-decreasing subsequence
## Medium 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">Given a sequence of n integers, the task is to find out the non-decreasing subsequence of length k with minimum sum. If no sequence exists output -1.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: N = 10, K = 3, arr[] = {58, 12, 
       11, 12, 82, 30, 20, 77, 16, 86}
<strong>Output:</strong> 39</span>
<span style="font-size:18px"><strong>Explanation</strong>: {11 + 12 + 16}</span></pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input: </strong>N = 10, K = 4, arr[] = {58, 12,
11, 12, 82, 30, 20, 77, 16, 86}
<strong>Output: </strong>120
<strong>Explanation</strong>: {11 + 12 + 16 + 77}</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong><code>minSum</code>()&nbsp;</strong>which takes <strong>N</strong>, <strong>K</strong> and array <strong>arr </strong>as input parameters and returns the sum.<br>
<br>
<strong>Expected Time Complexity:</strong> O(<strong>N*K</strong>)<br>
<strong>Expected Auxiliary Space:</strong> O(<strong>N*K</strong>)<br>
<br>
<strong>Constraints:</strong><br>
1 ≤ <strong>N, K</strong> ≤ 10<sup>3</sup></span><br>
<span style="font-size:18px">1 ≤ <strong>arr[i]</strong> ≤ 10<sup>5</sup></span></p>
 <p></p>
            </div>