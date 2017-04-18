import java.util.Scanner;

public class Calculator {

    private final String exitSymbol = "-q";
    private final String arithmeticMean = "-am";
    private final String geometricMean = "-gm";
    private boolean exception = true;

    public void start() {
            Scanner in = new Scanner(System.in);
            String stringCommand;
            String[] command;
            float[] arrayNum;
            do {
                System.out.println("Пожалуйста, вызовите программу с одним из следующих аргументов:");
                System.out.println(arithmeticMean + " <список чисел> - вычисляет среднее арифметическое для списка чисел.\nРазрешаются только положительные числа. Например: " + arithmeticMean + " 1 2 3 4 5");
                System.out.println(geometricMean + " <список чисел> - вычисляет среднее геометрическое для списка чисел.\nРазрешаются только положительные числа. Например: " + geometricMean + " 3 3 3");
                System.out.println("Для выхода введите " + exitSymbol);
                stringCommand = in.nextLine();
                command = stringCommand.split(" ");
                if (!command[0].equals(exitSymbol)) {
                    arrayNum = arrayNumber(command);
                    if (!command[0].equals(exitSymbol) && exception) {
                        switch (command[0]) {
                            case arithmeticMean:
                                System.out.printf("Среднее арифметическое: %.2f\n\n", arithmeticMean(arrayNum));
                                break;
                            case geometricMean:
                                System.out.printf("Среднее геометрическое: %.2f\n\n", geometricMean(arrayNum));
                                break;
                            default:
                                System.out.println("Неверная команда");
                        }
                    }
                }
            } while (!exitSymbol.equals(stringCommand));
            System.out.println("Всего доброго!");
    }

    private float[] arrayNumber(String[] stringCommand) {
        float[] arrayNumber = new float[stringCommand.length - 1];
        try {
            if (arrayNumber.length >= 2) {
                for (int i = 0; i < arrayNumber.length; i++) {
                    arrayNumber[i] = Float.parseFloat(stringCommand[i + 1]);
                    if (arrayNumber[i] < 0) {
                        System.out.println("Вы ввели неправильные аргументы, числа должны быть положительными.\n");
                        exception = false;
                        break;
                    }
                }
            } else {
                System.out.println("Вы должны ввести хотя бы два числа\n");
                exception = false;
            }
        } catch (Exception e) {
            System.out.println("Вы ввели неправильные аргументы.\n");
            exception = false;
        }
        return arrayNumber;
    }

    private float arithmeticMean(float[] array) {
        float sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    private double geometricMean(float[] array) {
        float mult = 1;
        float root = array.length;
        for (int i = 0; i < array.length; i++) {
            mult *= array[i];
        }
        return Math.pow(mult, 1 / root);
    }
}
