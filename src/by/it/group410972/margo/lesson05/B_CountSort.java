package by.it.group410972.margo.lesson05;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод со сложностью O(n)

Пример: https://karussell.wordpress.com/2010/03/01/fast-integer-sorting-algorithm-on/
Вольный перевод: http://programador.ru/sorting-positive-int-linear-time/
*/

public class B_CountSort {


    public static void main(String[] args) throws FileNotFoundException {
        InputStream stream = B_CountSort.class.getResourceAsStream("dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result = instance.countSort(stream);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    int[] countSort(InputStream stream) throws FileNotFoundException {

            Scanner scanner = new Scanner(stream);
            int n = scanner.nextInt();
            int[] points = new int[n];

            // читаем входные числа
            for (int i = 0; i < n; i++) {
                points[i] = scanner.nextInt();
            }

            // чисел всего 10 возможных (от 1 до 10), создаём массив частот
            int[] count = new int[11]; // индекс 0 не используется, т.к. числа только от 1

            // считаем вхождения
            for (int i = 0; i < n; i++) {
                count[points[i]]++;
            }

            // Формируем отсортированный массив
            int idx = 0;
            for (int num = 1; num <= 10; num++) {
                for (int j = 0; j < count[num]; j++) {
                    points[idx++] = num;
                }
            }

            return points;
        }

}
