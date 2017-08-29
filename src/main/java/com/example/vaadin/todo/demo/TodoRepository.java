package com.example.vaadin.todo.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by neman on 29/08/2017.
 */
public interface TodoRepository extends JpaRepository<Todo, Long>
{
}
