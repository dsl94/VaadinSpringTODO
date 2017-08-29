package com.example.vaadin.todo.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by neman on 29/08/2017.
 */
public interface TodoRepository extends JpaRepository<Todo, Long>
{
    @Transactional
    void deleteByDone(boolean done);
}
