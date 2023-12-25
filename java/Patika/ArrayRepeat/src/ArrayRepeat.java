public class ArrayRepeat {

    // https://app.patika.dev/moduller/java101/pratik-duplicate
    public static void main(String[] args) {
        int[] list = {12,5,6,4,7,11,2,9,22,66,1,36,12,8,9,6,5,14,17,13,18,22};
        int[] duplicate = new int[list.length];
        int startIndex = 0;

        for (int i = 0; i <list.length; i++) {
            for (int j = 0; j <list.length; j++) {
                if(i != j && list[i] == list[j] && list[i] % 2 == 0){
                    if(!isFind(duplicate, list[i])){
                        duplicate[startIndex++] = list[i];
                    }
                    break;
                }
            }
        }

    }

    public static boolean isFind(int[] duplicate, int value){
        for (int val : duplicate) {
            if(val == value){
                return true;
            }
        }
        System.out.print(value+ " ");
        return false;
    }
}
