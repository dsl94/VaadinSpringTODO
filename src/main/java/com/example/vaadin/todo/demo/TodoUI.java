package com.example.vaadin.todo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.KeyMapper;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by neman on 29/08/2017.
 */
@SpringUI
public class TodoUI extends UI
{

	private VerticalLayout root;

	@Autowired
	private TodoLayout todoLayout;

	@Override
	protected void init(VaadinRequest vaadinRequest)
	{
		setupLayout();
		addHeader();
		addForm();
		addTodoList();
		addDeleteButton();
	}

	private void setupLayout()
	{
		root = new VerticalLayout();
		root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		setContent(root);
	}

	private void addHeader()
	{
		Label label = new Label("TODOs");
		label.addStyleName(ValoTheme.LABEL_H1);
		root.addComponent(label);
	}

	private void addForm()
	{
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setWidth("80%");

		TextField task = new TextField();

		Button add = new Button("");
		add.addStyleName(ValoTheme.BUTTON_PRIMARY);
		add.setIcon(VaadinIcons.PLUS);

		horizontalLayout.addComponentsAndExpand(task);
		horizontalLayout.addComponents(add);

		add.addClickListener(clickEvent -> {
			todoLayout.add(new Todo(task.getValue()));
			task.clear();
			task.focus();
		});
		task.focus();
		add.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		root.addComponent(horizontalLayout);
	}

	private void addTodoList()
	{
		todoLayout.setWidth("80%");
		root.addComponent(todoLayout);
	}

	private void addDeleteButton()
	{
		root.addComponent(new Button("Delete completed"));
	}

}
