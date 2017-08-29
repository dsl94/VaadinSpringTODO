package com.example.vaadin.todo.demo;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by neman on 29/08/2017.
 */
@SpringComponent
public class TodoLayout extends VerticalLayout
{
	@Autowired
	private TodoRepository todoRepository;

	@PostConstruct
	void init()
	{
		setTodos(todoRepository.findAll());
	}

	private void setTodos(List<Todo> todos)
	{
		removeAllComponents();
		for (final Todo todo : todos)
		{
			addComponent(new TodoItemLayout(todo));
		}
	}

	public void add(Todo todo)
	{
		todoRepository.save(todo);
		setTodos(todoRepository.findAll());
	}
}
