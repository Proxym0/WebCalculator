package service;

import entity.Operation;

import java.util.Optional;

public interface Calculator {
    public Optional<Operation> calculator(Operation operation);

    double methodSum(double a, double b);

    double methodSub(double a, double b);

    double methodMult(double a, double b);

    double methodDiv(double a, double b);

}
