package in.dhanushselvam.kowmart.dao;

import java.util.List; 

import in.dhanushselvam.kowmart.Interface.TaskInterface;
import in.dhanushselvam.kowmart.model.Task;

public class TaskDAO implements TaskInterface {

	public List<Task> findAll() {
		List<Task> taskList = TaskList.listOfTask;
		return taskList;
	}

	public void create(Task newTask) {
		List<Task> taskList = TaskList.listOfTask;
		taskList.add(newTask);
	}

	public void update(int id, Task updatedTask) {

		List<Task> list = TaskList.listOfTask;

		for (Task name : list) {

			Task task = name;

			if (task.getId() == id) {
				task.setName(updatedTask.getName());
				task.setDueDate(updatedTask.getDueDate());
				break;
			}
		}

	}

	public void delete(int id) {

		List<Task> list = TaskList.listOfTask;

		for (Task name : list) {

			Task task = name;

			if (task.getId() == id) {
				task.setActive(false);
				break;
			}
		}
	}


	public Task findById(int taskId) {

		List<Task> taskList = TaskList.listOfTask;

		Task taskMatch = null;

		for (Task name : taskList) {

			Task task = name;

			if (task.getId() == taskId) {
				taskMatch = task;
				break;
			}
		}
		return taskMatch;
	}

}
