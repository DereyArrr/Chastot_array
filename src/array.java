import java.util.Arrays;

public class array {
    public static void main(String[] args) {
        //создаем начальный массив и заполняем его рандомными числами от 0 до 10
        int k = 10;
        int[] myArray = new int[k];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = ((int) (Math.random() * 10));
            System.out.print(myArray[i]);//выводим начальный массив
            System.out.print(" ");
        }

        //находим кол-во эл-ов нового массива
        int T = 1;//счетчик кол-ва эл-ов нового массива(без повторений)
        int H = 0;//счетчик для нахождения одинаковых эл-ов
        for (int i = 1; i < myArray.length; i++) {
            for (int j = 0; j < i; j++) {//сравниваем с каждым предыдущим эл-ом
                if (myArray[i] == myArray[j]) {
                    H++;
                }
            }
            if (H == 0) {//увеничивем счетчик кол-ва эл-тов, если эл-т ранее не встречался
                T++;
            }
            H = 0;//обнуляем для проверки след эл-та
        }
        System.out.print("; T=");
        System.out.print(T);

//создаем новый массив
        int[] array = new int[T];
        int index = 1;//счетчик для определения места в массиве, на которое поставим эл-т

        int h = 0;//счетчик для нахождения равных эл-ов
        array[0] = myArray[0];// 0 эл-т записываем в массив
        for (int i = 1; i < myArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (myArray[i] == myArray[j]) {
                    h++;
                }
            }
            if (h == 0) {//запись в новый массив
                array[index] = myArray[i];
                index++;
            }
            h = 0;
        }
        
        System.out.print("; ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }//выводим массив без повторений

        int count = 0;//счетчик повторений каждого элемента
        int[][] newArray = new int[2][T];//создаем двумерный массив
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (array[i] == myArray[j]) {//сравниваем эл-ты исходного массива и массива без повторений
                    count++;//считаем кол-во повторений
                }
            }
            newArray[0][i] = array[i];//записываем эл-т в двумерный массив
            newArray[1][i] = count;//записываем кол-во повторений данного эл-та
            count = 0;
        }

        //вывод двумерного массива на экран
        System.out.print("; ");
        System.out.println(Arrays.deepToString(newArray));
    }
}



