package service;

import entity.Operation;
import storage.InFileOperationStorage;
import storage.InMemoryOperationStorage;
import storage.JDBCOperationStorage;
import storage.OperationStorage;

import java.util.List;
import java.util.Optional;

public class CalculatorService implements Calculator {
    private final OperationStorage inMemoryOperationStorage = new InMemoryOperationStorage();
    private final InFileOperationStorage inFileOperationStorage = new InFileOperationStorage();
    private final JDBCOperationStorage jdbcOperationStorage = new JDBCOperationStorage();

    public Optional<Operation> calculator(Operation operation) {

        switch (Functions.valueOf(operation.getType().toUpperCase())) {
            case SUM: {
                double sum = methodSum(operation.getNum1(), operation.getNum2());
                operation.setResult(sum);
                inMemoryOperationStorage.save(operation);
                inFileOperationStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return Optional.of(operation);
            }
            case SUB: {
                double sub = methodSub(operation.getNum1(), operation.getNum2());
                operation.setResult(sub);
                inMemoryOperationStorage.save(operation);
                inFileOperationStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return Optional.of(operation);
            }
            case MULT: {
                double mult = methodMult(operation.getNum1(), operation.getNum2());
                operation.setResult(mult);
                inMemoryOperationStorage.save(operation);
                inFileOperationStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return Optional.of(operation);
            }
            case DIV: {
                double div = methodDiv(operation.getNum1(), operation.getNum2());
                operation.setResult(div);
                inMemoryOperationStorage.save(operation);
                inFileOperationStorage.save(operation);
                jdbcOperationStorage.save(operation);
                return Optional.of(operation);
            }
        }
        return Optional.empty();
    }

    public List<Operation> showHistory() {
        return inMemoryOperationStorage.findAll();
    }


    public double methodSum(double a, double b) {
        return a + b;
    }

    public double methodSub(double a, double b) {
        return a - b;
    }

    public double methodMult(double a, double b) {
        return a * b;
    }

    public double methodDiv(double a, double b) {
        return a / b;
    }
}
