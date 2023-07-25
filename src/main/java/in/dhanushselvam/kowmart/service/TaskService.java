package in.dhanushselvam.kowmart.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import in.dhanushselvam.kowmart.dao.TaskDAO;
import in.dhanushselvam.kowmart.dao.UserDAO;
import in.dhanushselvam.kowmart.exception.ValidationException;
import in.dhanushselvam.kowmart.model.Task;
import in.dhanushselvam.kowmart.model.TaskEntity;
import in.dhanushselvam.kowmart.model.User;
import in.dhanushselvam.kowmart.validation.TaskValidator;
import in.dhanushselvam.kowmart.validation.UserValidator;

public class TaskService {

	private TaskDAO taskDao;

	public TaskService() {
		this.taskDao = new TaskDAO();
	}

	public List<Task> getAll() {

		List<Task> taskList = taskDao.findAll();
		for (Task task : taskList) {
			System.out.print(task);
		}
		return taskList;
	}

	public void create(Task newTask) throws Exception {

		TaskValidator.validate(newTask);
		TaskDAO taskDao = new TaskDAO();
		taskDao.create(newTask);

	}

	public void update(int id, Task updatedUser) {

		TaskDAO taskDao = new TaskDAO();
		taskDao.update(id, updatedUser);

	}

	public void delete(int id) {

		TaskDAO taskDao = new TaskDAO();
		taskDao.delete(id);
	}

	public static LocalDate convertToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			return localDate;
		} catch (Exception e) {
			System.out.println("Invalid date format!");
			return null;
		}
	}

}
