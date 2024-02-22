package br.com.erudio.math;

public class SimpleMath {
    public Double sum(double numberOne,
                      double numberTwo) {

        return numberOne + numberTwo;
    }

    public Double subtraction( double numberOne,
                               double numberTwo) {

        return numberOne - numberTwo;
    }
    public Double multiplication( double numberOne,
                                  double numberTwo){



        return numberOne * numberTwo;
    }
    public Double division(double numberOne,
                           double numberTwo) {


        return numberOne /numberTwo;
    }
    public Double mean(double numberOne,
                       double numberTwo,
                       double numberThree
    ) {


        double sum = numberOne + numberTwo + numberThree;
        return sum / 3;
    }

    public Double squareRoot(double number) {

        return Math.sqrt(number);
    }
}
