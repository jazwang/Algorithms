import java.util.List;

public class Sort {

    public static void main(String[] args)
    {
        int[] arr = { 38, 27, 43, 3, 9 ,82, 10};
        printArray(arr);

        mergeSort(arr);


        printArray(arr);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    /*        - Merge Sort -
        Divide whole list into halves
        Recursively call on first half
        Recursively call on second half
        Call Merge() on above halves

        Runtime: O(nlogn) average and worst
        Memory: depends - O(n)
     */
    static void mergeSort(int[] arr)
    {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length-1);
    }

    static void mergeSort(int[] arr, int[] helper, int l, int r)
    {
        if (l < r)
        {
            int mid = (l + r)/2;
            mergeSort(arr, helper, l, mid);
            mergeSort(arr, helper, mid + 1, r);
            merge(arr, helper, l, mid, r);
        }
    }

    static void merge(int[] arr, int[] helper, int left, int mid, int right)
    {
        //copy both halves into helper arr
        for (int i = left; i <= right; i ++)
        {
            helper[i] = arr[i];
        }

        int helperLeft = left;
        int helperRight = mid + 1;
        int current = left;

        while (helperLeft <= mid && helperRight <= right)
        {
            if (helper[helperLeft] <= helper[helperRight])
            {
                arr[current] = helper[helperLeft];
                helperLeft ++;
            }
            else
            {
                arr[current] = helper[helperRight];
                helperRight ++;
            }
            current ++;
        }

        /*  copy what's left in left half
            no need to copy right those stay the same in arr
            needs to use `remaining` instead of helperLeft
            because helperLeft index is already overwritten
         */
        int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining; i ++)
        {
            arr[current + i] = helper[helperLeft + i];
        }

    }

    static int[] quickSort(int[] list)
    {
        return null;
    }
}
