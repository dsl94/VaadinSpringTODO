package com.example.vaadin.todo.demo;

import javax.persistence.*;

/**
 * Created by neman on 29/08/2017.
 */
@Entity
public class Todo
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String text;

	private boolean done;

	public Todo(){}

	public Todo(String text)
	{
		this.text = text;
	}

	public Todo(String text, boolean done)
	{
		this.text = text;
		this.done = done;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public boolean isDone()
	{
		return done;
	}

	public void setDone(boolean done)
	{
		this.done = done;
	}

	@Override
	public String toString()
	{
		return "Todo{" +
			"id=" + id +
			", text='" + text + '\'' +
			", done=" + done +
			'}';
	}
}
