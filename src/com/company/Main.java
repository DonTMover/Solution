package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 0 для обычного калькулятора или 1 для продвинутого");
        byte answer = sc.nextByte();
        if (answer == 0) {
            standartFlow();
        }else{
            FlowRateWithLoad();
        }
    }

    public static double calc(double mileage, double flow) {
        return (flow / mileage) * 100;
    }

    public static double EnterANumber(String text) {
//        System.out.println("Вместо . - ,");
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        if (sc.hasNextDouble()) {
            double number = sc.nextDouble();
            System.out.println("Спасибо! Вы ввели число " + number);
            return number;
        } else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
            return 0;
        }

    }

    // cooficient - коофицент топлива + на 1 тонну
    public static double profcalc(double mileage, double cooficient, double EmptyFlow, double weight) {return (((mileage * EmptyFlow) / 100) + (mileage * (cooficient * weight)));}
    public static double FlowRateWithLoad(){
        double cooficent = EnterANumber("Введите коофицент расхода литров на тонну груза");
        double mileage = EnterANumber("Введите число пройденных километров от A до B");
        double EmptyFlow = EnterANumber("Введите ваш расход при условии что вы пустой");
        double weight = EnterANumber("Введите вес вашего груза");
        System.out.println("Ваш расход на " + mileage + " км состовляет: " + profcalc(mileage,cooficent,EmptyFlow,weight));
        return profcalc(mileage,cooficent,EmptyFlow,weight);
    }
    public static double standartFlow(){
        System.out.println("Добро Пожаловать в расчет расхода за 100 км!");
        double mileage = EnterANumber("Введите число пройденых километров");
        double flow = EnterANumber("Введите число потраченого топлива за этот километраж");
        System.out.print("Ваш расход на 100 км состовляет " + calc(mileage, flow));
        return calc(mileage, flow);
    }
}