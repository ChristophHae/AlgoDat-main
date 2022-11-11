import java.util.Arrays;

public class pflichtaufgabe_main {
    public static void main (String[] args)
    {
        int[] a = new int[10];

        for(int i = 0; i<a.length; i++) {
            a[i] = i;
        }
        System.out.println("BubbleSort:");
        SortUtils.shuffle(a);
        System.out.println(Arrays.toString(a));
        SortUtils.bubbleSort(a);
        System.out.println(Arrays.toString(a));

        System.out.println("InsertionSort:");
        SortUtils.shuffle(a);
        System.out.println(Arrays.toString(a));
        SortUtils.insertionSort(a);
        System.out.println(Arrays.toString(a));

        System.out.println("MergeSort:");
        SortUtils.shuffle(a);
        System.out.println(Arrays.toString(a));
        SortUtils.mergeSort(a);
        System.out.println(Arrays.toString(a));

        System.out.println("HeapSort:");
        SortUtils.shuffle(a);
        System.out.println(Arrays.toString(a));
        SortUtils.heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
