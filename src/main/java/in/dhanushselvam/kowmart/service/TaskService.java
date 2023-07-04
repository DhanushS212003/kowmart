package in.dhanushselvam.kowmart.service;

import in.dhanushselvam.kowmart.dao.TaskDAO;
import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.Task;
import in.dhanushselvam.kowmart.validation.TaskValidator;

public class TaskService {

	public Task[] getAll() {

		TaskDAO TaskDao = new TaskDAO();
		Task[] taskList = TaskDao.findAll();

		for (int i = 0; i < taskList.length; i++) {
			System.out.println(taskList[i]);
		}

		return taskList;

	}

	public void create(Task task) throws ValidationException {

		TaskValidator.validate(task);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(task);

	}

	public void update() {

		Task updatedTask = new Task();

		updatedTask.setName("Dhanush");

		TaskDAO taskDao = new TaskDAO();
		taskDao.update(2, updatedTask);

	}

	public void delete() {

		Task deleteTask = new Task();
		deleteTask.setActive(false);

		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(2, deleteTask);
	}

	public Task getById() {

		TaskDAO taskDao = new TaskDAO();
		Task task = taskDao.getById(1);
		System.out.println(task);
		return task;

	}

}
