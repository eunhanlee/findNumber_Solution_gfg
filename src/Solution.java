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
