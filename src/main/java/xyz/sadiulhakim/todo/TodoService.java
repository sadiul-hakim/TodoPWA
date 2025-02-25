package xyz.sadiulhakim.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public void save(Todo todo) {
        todo.setCreationDate(LocalDateTime.now());
        todoRepo.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepo.findAll();
    }

    public void delete(long id) {
        todoRepo.deleteById(id);
    }
}
