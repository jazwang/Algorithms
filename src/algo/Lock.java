import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Lock {
    public static void main(String[] args)
    {
        System.out.println(checkLock(new String[]{"ACQUIRE 364", "ACQUIRE 84", "RELEASE 364", "RELEASE 84"}));
    }

    public static int checkLock(String[] sequence)
    {
        if (sequence == null || sequence.length == 0)
        {
            return 0;
        }

        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < sequence.length; i ++)
        {
            String[] curr = sequence[i].split(" ");
            String event = curr[0];
            String lock = curr[1];
            if (event.equals("ACQUIRE"))
            {
                if (set.contains(lock))
                {
                    return i+1;
                }
                set.add(lock);
                stack.push(lock);
            }
            else
            {
                if(stack.isEmpty() || !stack.peek().equals(lock))
                {
                    return i + 1;
                }
                if (stack.peek().equals(lock))
                {
                    set.remove(stack.pop());
                }
            }

        }
        return stack.isEmpty()? 0 : sequence.length + 1;
    }

}
