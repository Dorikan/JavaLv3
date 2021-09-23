public class Main {
    public static void main(String[] args) {

    }
    private static int[] first(int[] arr) {
        //{1,2,3,4,6,8}
        //{4,1,4,7,9}
        //{0,0,0,0}
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i] == 4) {
                int[] outArray = new int[arr.length -1 - i];
                int k=0;
                for (int j = i+1; j < arr.length; j++) {
                    outArray[k] = arr[j];
                    System.out.println(outArray[k] + ", ");
                    k++;
                }
                return outArray;
            }
        }
        throw new RuntimeException("4 not found");
    }
    private static boolean second (int[] inputArr) {
        //{1,2,3,4, 5, 6, 7, 8}
        //{1, 4}
        //{0,0,0,0}
        boolean one = false;
        boolean four = false;
        for (int a : inputArr) {
            if (a != 1 && a !=4)
                return false;
            if (a == 1)
                one = true;
            if (a == 4)
                four = true;
        }
        return (one && four);
    }
}
