import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args)
    {
        int[] arr = { 38, 27, 43, 3, 9 ,82, 10};
        printArray(arr);

//        mergeSort(arr);
//        quickSort(arr);
        radixSort(arr);
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

    /*
        - Quick Sort -
        Pick a random element and partition the arr
        all nums less than this elem coms before it
        all nums greater than this elem come after it
        swapping technique

        Runtime: O(nlogn) average; O(n^2) worst
        Memory: O(logn)
     */
    static void quickSort(int[] arr)
    {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int left, int right)
    {
        int index = partition(arr, left, right);
        if (left < index - 1)
        {
            quickSort(arr, left, index -1);
        }
        if (index < right)
        {
            quickSort(arr, index, right);
        }
    }

    static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[(left + right)/2];
        while (left <= right)
        {
            while (arr[left] < pivot) //move left inwards till finds an elem >= pivot
            {
                left ++;
            }

            while(arr[right] > pivot) //move right inwards till finds an elem <= pivot
            {
                right --;
            }

            if (left <= right) // dont swap if left > right
            {
                swap(arr, left, right);
                left ++;
                right --;
            }
        }
        return left; //partition point for dividing arr into halves
    }

    static void swap(int[] arr, int left, int right)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    /*
        - Radix Sort -
        takes advantage of integers having a finite number of bits
        sort from least significant (right-most)
        to most significant (left-most) digit
        uses countSort()

        Runtime: O(kn) [ k is the number of passes ]
     */
    static void radixSort(int[] arr)
    {
        int max = getMax(arr);

        for (int exp = 1; max/exp>0; exp *=10)
        {
            countSort(arr, exp);
        }
    }

    static void countSort(int[] arr, int exp)
    {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < arr.length; i ++)
        {
            count[(arr[i]/exp)%10] ++;
        }

        for (int i = 1; i < 10; i ++)
        {
            count[i] += count[i -1];
        }

        // Build the result array
        for (int i = arr.length - 1; i >= 0; i--)
        {
            result[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the result array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (int i = 0; i < arr.length; i++)
            arr[i] = result[i];
    }

    static int getMax(int[] arr)
    {
        int max = arr[0];
        for (int i : arr)
        {
            if(i > max)
            {
                max = i;
            }
        }
        return max;
    }
}
