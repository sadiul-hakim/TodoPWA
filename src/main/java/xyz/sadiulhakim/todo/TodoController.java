package xyz.sadiulhakim.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", service.findAll());
        return "todos";
    }

    @PostMapping("/add")
    public String addTodo(@ModelAttribute Todo todo, Model model) {
        service.save(todo);
        model.addAttribute("todos", service.findAll());
        return "todos :: todo-list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, Model model) {
        service.delete(id);
        model.addAttribute("todos", service.findAll());
        return "todos :: todo-list";
    }
}
