import java.util.Arrays;
import java.util.Random;

public class SortUtils {
    private static Random random = null;

    public static void shuffle(int [] a)
    {
        if(random==null) {
            random = new Random ( ) ;
        }
        for(int i=a.length-1; i>0; i--) {
            swap(a, i , random.nextInt(i+1));
        }
    }
    public static void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void bubbleSort(int [] a) {
        int m = a.length;

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<m-1; j++) {
                if(a[j]>a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }


    public static void insertionSort(int [] a) {
        for(int j = 1; j<=a.length-1; j++) {
            int x = a[j];
            int i = j-1;
            while(i >= 0 && a[i] > x) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = x;
        }

    }


    public static void mergeSort(int[] a) {
        if (a.length > 1) {

            int[] al;
            int[] ar;

            // Aufteilen des Arrays in 2
            //zu beachten: wenn die Länge des Arrays ungerade ist, müssen die array al und ar ungleich erstellt werden, bei uns ist al eins länger
            if(a.length%2 != 0) {
                al = new int[a.length/2+1];
                ar = new int[a.length/2];
            }
            else {
                al = new int[a.length/2];
                ar = new int[a.length/2];
            }

            //Anstatt iterativ das Array durchzugehen, nutzen wir die arraycopy methode um das vorhandene Array ab der Hälfte, bzw. bis zur Hälfte zu kopieren
            //https://stackoverflow.com/questions/5731042/split-array-into-two-parts-without-for-loop-in-java als Quelle für arraycopy()
            System.arraycopy(a, 0, al, 0, al.length);
            System.arraycopy(a, al.length, ar, 0, ar.length);

            System.out.println(Arrays.toString(al));
            System.out.println(Arrays.toString(ar));
            // rekursiv im linken bzw. rechten array weitermachen
            mergeSort(al);
            mergeSort(ar);
            // arrays zusammmenführen
            merge(a, al, ar);
        }
    }


    private static void merge(int a[], int al[], int ar[]) {
        int x = 0;
        int y = 0;
        int z = 0;

        while(x<al.length && y<ar.length) {
            if(al[x]<=ar[y]){
                a[z++] = al[x++];
                System.out.println(Arrays.toString(a));
            }
            else {
                a[z++] = ar[y++];
                System.out.println(Arrays.toString(a));
            }
        }

        // letztes element einfügen
        while(x<al.length) {
            a[z++] = al[x++];
            System.out.println(Arrays.toString(a));
        }

        // letztes element einfügen
        while(y<ar.length) {
            a[z++] = ar[y++];
            System.out.println(Arrays.toString(a));
        }

    }


    public static void heapSort(int [] a){
        buildHeap(a);
        for (int i = a.length-1; i>=1; i--) {
            swap(a, 0, i);
            heapify(a, 0, i-1);
        }
    }

    private static void buildHeap(int [] a) {

       for (int i = a.length/2; i>=0; i--) {
           heapify(a, i, a.length-1);
       }
    }

    private static void heapify(int [] a, int i , int j) {
        int left = 2 * i + 1; //Baum sortiert, im array reihenfolge noch falsch
        int right = 2 * i + 2;
        int max = i;

        if (left <= j && a[left] > a[max]) { //j=length-1
            max = left;
        }
        if (right <= j && a[right] > a[max]) {
            max = right;
        }


        if (max != i) {
            swap(a, i, max);
            heapify(a, max, j);
        }
    }
}
