package com.company;

import java.util.Scanner;

public class Main {
    private static final String exitSymbol = "-q";
    private static final String arithmeticMean = "-am";
    private static final String geometricMean = "-gm";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringCommand;
        String[] command;
        do {
            System.out.println("Пожалуйста, вызовите программу с одним из следующих аргументов:");
            System.out.println(arithmeticMean + " <список чисел> - вычисляет среднее арифметическое для списка чисел.\nРазрешаются только положительные числа. Например: " + arithmeticMean + " 1 2 3 4 5");
            System.out.println(geometricMean + " <список чисел> - вычисляет среднее геометрическое для списка чисел.\nРазрешаются только положительные числа. Например: " + geometricMean +" 3 3 3");
            System.out.println("Для выхода введите " + exitSymbol);
            stringCommand = in.nextLine();
            command = stringCommand.split(" ");
            arrayNumber(command);
            switch (command[0]) {
                case arithmeticMean:
                    System.out.println("-am");
                    System.out.printf("Среднее арифметическое: %.2f\n\n", arithmeticMean(arrayNumber(command)));
                    break;
                case geometricMean:
                    System.out.println("-gm");
                    System.out.printf("Среднее геометрическое: %.2f\n\n", geometricMean(arrayNumber(command)));
                    break;
                case exitSymbol:
                    System.out.println("Всего доброго!");
                    break;
                default:
                    System.out.println("Неверная команда");
            }
        } while (!exitSymbol.equals(stringCommand));

    }

    private static float[] arrayNumber(String[] stringCommand){
        float[] array = new float[stringCommand.length-1];
        for (int i = 0; i <array.length ; i++) {
            array[i] = Float.parseFloat(stringCommand[i+1]);
        }
        return array;
    }


    private static float arithmeticMean(float[] array){
        float sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }

    private static double geometricMean(float[] array){
        float mult = 1;
        float root = array.length;
        for (int i = 0; i <array.length; i++) {
            mult *= array[i];
        }
        return Math.pow(mult, 1/root);
    }

}
