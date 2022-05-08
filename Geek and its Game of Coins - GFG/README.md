# Geek and its Game of Coins
## Easy 
<div class="problem-statement">
                <p></p><p style="text-align:justify"><span style="font-size:18px">Given three numbers <strong>N</strong>, <strong>X</strong>, and <strong>Y</strong>. Geek and his friend playing a coin game. At the beginning, there are<strong>&nbsp;N</strong>&nbsp;coins. In each move, a player can pick <strong>X,</strong>&nbsp;<strong>Y</strong>, or <strong>1</strong> coin. Geek&nbsp;always starts the game. The player who picks the last coin wins the game. The task is to check whether Geek&nbsp;will win the game or not if both are playing optimally.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: N = 5, X = 3, Y = 4
<strong>Output:</strong> 1</span>
<span style="font-size:18px"><strong>Explanation</strong>: There are 5 coins, every 
player can pick 1 or 3 or 4 coins on 
his/her turn. Geek can win by picking 
3 coins in first chance. Now 2 coins 
will be left so his frined will pick 
one coin and now Geek can win by 
picking the last coin.</span></pre>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input</strong>: N = 2, X = 3, Y = 4
<strong>Output:</strong> 0</span>
<span style="font-size:18px"><strong>Explanation</strong>: Geek picks 1 and then 
his friend picks 1</span></pre>

<div><br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Complete the function <strong><code>findWinner</code>()&nbsp;</strong>which takes <strong>N</strong><strong>, X, </strong>and<strong> Y </strong>as input parameters and returns 1 if Geek can win otherwise 0.<br>
<br>
<strong>Expected Time Complexity:</strong> O(<strong>|N|</strong>)<br>
<strong>Expected Auxiliary Space:</strong> O(<strong>|N|</strong>)<br>
<br>
<strong>Constraints:</strong><br>
1 ≤ <strong>|N|</strong> ≤ 10<sup>6</sup></span></div>
 <p></p>
            </div>