package by.tms.storage;

import by.tms.entity.Operation;
import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface OperationStorage {

    void save(Operation operation);

    List<Operation> findAll();
}
