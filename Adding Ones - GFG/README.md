# Adding Ones
## Easy 
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You start with an array <strong>A</strong> of size <strong>N</strong>. Also, <strong>A[i] = 0</strong> for <strong>i = 1</strong> to <strong>N</strong>. You will be given <strong>K</strong> positive integers. Let <strong>j</strong> be one of these integers, you have to add <strong>1</strong> to all <strong>A[i]</strong>, for<strong> i ≥ j</strong>. Your task is to print array A after all these <strong>K</strong> updates are done.</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1: </strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
3 4
1 1 2 3
<strong>Output:</strong>
2 3 4
<strong>Explanation:</strong>
Initially the array is {0, 0, 0}. After the
first 1, it becomes {1, 1, 1}. After the
second 1 it becomes {2, 2, 2}. After 2, it 
becomes {2, 3, 3}. After 3 it becomes, {2, 3, 4}. </span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2: </strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
2 3
1 1 1
<strong>Output:</strong>
3 3 
<strong>Explanation:</strong>
Initially the array is {0, 0}. After the
first 1, it becomes {1, 1}. After the
second 1 it becomes {2, 2}. After the
third 1, it becomes {3, 3}.</span></pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>update()</strong>&nbsp;which takes the array <strong>A[]</strong> and its size <strong>N</strong><strong> </strong>as inputs and make the updates and fill the array <strong>A[].</strong></span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity: </strong>O(N)<br>
<strong>Expected Auxiliary Space: </strong>O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N, K ≤ 10<sup>5</sup></span></p>
 <p></p>
            </div>