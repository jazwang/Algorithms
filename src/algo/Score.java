public class Score {

    public static void main(String[] args)
    {
        char[] num = {'7','6','5'};
        int s1 = rule1(num, '7');
        int s2 = rule2(num, '2');
        int s3 = rule3(num);
        int s4 = rule4(765, 3);
        int s5 = rule5(num);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        System.out.println(s1 + s2 + s3 + s4 + s5);
    }

    public static int rule1(char[] nums, char target)
    {
        int score = 0;
        for (char c : nums)
        {
            if (c == target)
            {
                score += 5;
            }
        }
        return score;
    }

    public static int rule2(char[] nums, char target)
    {
        int score = 0;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] == target && nums[i - 1] == target)
            {
                score += 6;
            }
        }
        return score;
    }

    public static int rule3(char[] nums)
    {
        int score = 0;
        int length = 1;

        for (int i = 1; i < nums.length; i ++)
        {
            if (nums[i] < nums[i-1])
            {
                length ++;
            }
            else
            {
                score += Math.pow(length,2);
                length = 1;
            }
        }
        score += Math.pow(length, 2);
        return score;
    }

    public static int rule4(int num, int target)
    {
        if (num % target == 0)
        {
            return 4;
        }
        return 0;
    }

    public static int rule5(char[] nums)
    {
        int score = 0;
        for (char c : nums)
        {
            int digit = c - '0';
            if (digit % 2 == 0)
            {
                score += 3;
            }
        }
        return score;
    }
}
