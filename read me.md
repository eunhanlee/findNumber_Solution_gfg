# find number Problem Solved: Uncover the Most Efficient Java Algorithm

https://eunhanspace.blogspot.com/

# Problem

[Problem_Link](https://practice.geeksforgeeks.org/problems/35bff0ee40090b092e97b02f649085bf1390cc67/1)

## **Problem Solving Approach**

- Odd digit numbers have a pattern
    
    
    | 1 | 3 | 5 | 7 | 9 |
    | --- | --- | --- | --- | --- |
    | 11 | 13 | 15 | 17 | 19 |
    | 31 | 33 | 35 | 37 | 39 |
    | 51 | 53 | 55 | 57 | 59 |
    | 71 | 73 | 75 | 77 | 79 |
    | 91 | 93 | 95 | 97 | 99 |
    | 101 | 103 | 105 | 107 | 109 |
- As seen above, the pattern repeats every 5 numbers.
- Therefore, we can know the position of each digit by dividing N by 5.
- If we know the position of each digit, we can find out what number will be in that position (1, 3, 5, 7, 9)
- Let's take the 13th odd digit number as an example
    - The rightmost digit (ones place) in 13 is the 3rd.
    - According to the odd digit pattern, the third number is 5.
    - The second rightmost digit (tens place) in 13 is the 2nd.
    - According to the odd digit pattern, the second number is 3.
    - In conclusion, the 13th odd digit number is 35.
- Let's take the 27th odd digit number as an example
    - The rightmost digit (ones place) in 27 is the (27%5) 2nd.
    - According to the odd digit pattern, the second number is 3.
    - Excluding the calculated digits from 27, we get 27-27%5 = 27/5=5.
    - The second rightmost digit (tens place) is the (5%5) 5th.
    - According to the odd digit pattern, the fifth number is 9.
    - In conclusion, the 27th odd digit number is 93.
- There is something slightly incorrect with the above pattern. For example, 5%5 is 0. However, we want the pattern to follow the table above.
    
    ```java
    - n % 5 = 0 //5th number = 9
    - n % 5 = 1 //1th number = 1
    - n % 5 = 2 //2th number = 3
    - n % 5 = 3 //3th number = 5
    - n % 5 = 4 //4th number = 7
    ```
    
    To fix this, we subtract 1 from n.
    
    ```java
    - n-1 % 5 = 0 //1th number = 1
    - n-1 % 5 = 1 //2th number = 3
    - n-1 % 5 = 2 //3th number = 5
    - n-1 % 5 = 3 //4th number = 7
    - n-1 % 5 = 4 //5th number = 9
    ```
    
- Lastly, when we get 0, 1, 2, 3, 4, the actual numbers we want are 1, 3, 5, 7, 9. To optimize this, we multiply by 2 and add 1.
    
    ```java
    0*2+1=1
    2*2+1=3
    3*2+1=5
    4*2+1=7
    5*2+1=9
    ```
    

# Time **O(log n), Space O(1)**

```java
class Solution
{
    /**
     * Finds the Nth number containing only odd digits.
     *
     * @param N The position of the desired number.
     * @return The Nth number containing only odd digits.
     */
    public long findNumber(long N)
    {
        // The variable to store the final result
        long result = 0;
        // The variable to represent the digit position (1, 10, 100, ...)
        long position = 1;

        // Continue until N is greater than 0
        while (N > 0)
        {
            // Calculate the odd digit by subtracting 1 from N and dividing by 5
            long oddDigit = ((N - 1) % 5) * 2 + 1;
            // Subtract 1 from N and divide by 5 to prepare for the next digit calculation
            N = (N - 1) / 5;
            // Add the odd digit multiplied by the current position to the result
            result += oddDigit * position;
            // Move to the next digit position
            position *= 10;
        }

        // Return the Nth number containing only odd digits
        return result;
    }
}
```

## **Explanation**

- The given integer N is repeatedly divided by 5 during the computation process, which reduces its value. In this process, odd-digit numbers are generated. The loop continues as long as N is greater than 0.
- With each iteration, N is updated to (N - 1) / 5. This process reduces N by more than half, causing N to decrease significantly with each iteration. Since N is almost halved with each iteration, the time complexity can be considered as O(log N).