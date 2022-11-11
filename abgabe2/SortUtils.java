  import java.io.PrintStream;
  import java.util.Random;

  public class SortUtils {
    private static Random random = null;
    private static final int rounds = 10;
  
    public static void shuffle(int[] a) {
      if (random == null) random = new Random();
      int n = a.length;
      for(int r=0; r<rounds; r++)       
      for (int i=0; i<n; i++) swap(a, i, random.nextInt(n));
    }

    /**************************************************************/
    
    public static void swap(int[] a, int i, int j) {
      int tmp =  a[i];
      a[i] = a[j];
      a[j] = tmp;
    }
 
    public static void quickSort(int[] a){
      quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int i, int j) {
        /* TODO */
    }
    
    private static int partition(int[] a, int b, int e) {
        /* TODO */
    }
  }
