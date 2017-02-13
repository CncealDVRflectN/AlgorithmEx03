import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class AlgEx {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        int mtrNum = scanner.nextInt();
        int[] sizes = new int[mtrNum + 1];
        for(int i = 0; i < mtrNum - 1; i++) {
            sizes[i] = scanner.nextInt();
            scanner.nextInt();
        }
        sizes[mtrNum - 1] = scanner.nextInt();
        sizes[mtrNum] = scanner.nextInt();
        writer.write(minMul(mtrNum, sizes) + "");
        writer.close();
        scanner.close();
    }

    private static int minMul(int mtrNum, int[] sizes) {
        int[][] mulMtr = new int[mtrNum][mtrNum];
        int j;
        for(int l = 1; l < mtrNum; l++) {
            for(int i = 0; i < mtrNum - l; i++) {
                j = i + l;
                mulMtr[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++) {
                    mulMtr[i][j] = Math.min(mulMtr[i][j], mulMtr[i][k] + mulMtr[k + 1][j] + sizes[i] * sizes[k + 1] * sizes[j + 1]);
                }
            }
        }
        return mulMtr[0][mtrNum - 1];
    }
}
