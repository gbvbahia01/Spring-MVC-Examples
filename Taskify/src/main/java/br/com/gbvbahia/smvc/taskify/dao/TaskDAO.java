package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.Task;
import java.util.List;


public interface TaskDAO {
	void createTask(Task task);

	Task findById(int taskId);

	List<Task> findByAssignee(int assigneeId);

	List<Task> findByAssignee(String assigneeUserName);

	List<Task> findAllTasks();

	int findAllTasksCount();

	List<Task> findAllOpenTasks();

	int findAllOpenTasksCount();

	List<Task> findOpenTasksByAssignee(int assigneeId);

	List<Task> findOpenTasksByAssignee(String assigneeUserName);

}
