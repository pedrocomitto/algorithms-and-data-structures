Given a staircase with a number of degrees n, write a function which takes the integer n and returns the number of ways you can go from the bottom to the top.
You can take only one or two steps at a time.

The first solution works but there is a problem: during the recursive calls, the algorithm keeps searching for values that it had already found.

The formula is: numberWays[n] = numberWays[n - 2] + numberWays[n - 1]

            nw(4)
           /     \
        nw(3)   nw(2)
       /    \
    nw(2)   nw(1)

In this case, even without needing it, we process the nw(2) twice.

The second solution uses the bottom up approach, from dynamic programming, to solve it.


