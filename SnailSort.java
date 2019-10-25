class SnailSort {

    public static void main(String[] args) {
        int[] answer = snail(new int[][]{{}} );
        printAnswer(answer);
    }

    public static int[] snail(int[][] array) {
        if(array.length == 0 || array[0].length == 0) {
            return new int[]{};
        }
        if(array.length == 1 && array[0].length == 1) {
            return array[0];
        } else {
            int[][] snailCut = snailCut(array);
            return concatArray(array[0], snail(rotateMatrix(snailCut)));
        } 
    } 

    public static int[] concatArray(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static int[][] snailCut(int[][] array) {
        int[][] snailCut = new int[array.length - 1][array[0].length];
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < snailCut[0].length; j++) {
                snailCut[i-1][j] = array[i][j];    
            }            
        }
        return snailCut;
    }

    public static int[][] rotateMatrix(int[][] array) {
        int[][] rotatedArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                rotatedArray[rotatedArray.length - 1 - j][i] = array[i][j];
            }
        }
        return rotatedArray;
    }

    public static void printAnswer(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}