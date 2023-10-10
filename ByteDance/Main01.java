package ByteDance;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        String string = scanner.nextLine();
        int[] results = new int[q]; 

        for (int i = 0; i < q; i++) {
            String word = scanner.nextLine();
            int occurrences = countWordOccurrences(string, word);
            results[i] = occurrences;
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int countWordOccurrences(String string, String word) {
        int count = 0;
        int index = 0;
        while (index < string.length()) {
            index = string.indexOf(word, index);
            if (index == -1) {
                break;
            }
            count++;
            index += 1;
        }
        return count;
    }
}