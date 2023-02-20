package by.tms.storage;

import by.tms.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {
    List<Operation> operationsList = new ArrayList<>();

    public void save(Operation operation) {
        operationsList.add(operation);
    }

    public List<Operation> findAll() {
        return new ArrayList<>(operationsList);
    }
}