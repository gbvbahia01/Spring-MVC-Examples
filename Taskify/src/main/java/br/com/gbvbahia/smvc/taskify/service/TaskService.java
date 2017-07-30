package br.com.gbvbahia.smvc.taskify.service;

import br.com.gbvbahia.smvc.taskify.domain.Task;
import java.util.List;


public interface TaskService {
	Task createTask(Task task);

	Task createTask(String name, int priority, Long createdByuserId, Long assigneeUserId, String comments);

	Task findTaskById(Long taskId);

	List<Task> findTasksByAssignee(Long assigneeId);

	List<Task> findAllTasks();

	int findAllTasksCount();

	List<Task> findAllOpenTasks();

	List<Task> findAllCompletedTasks();

	int findAllOpenTasksCount();

	int findAllCompletedTasksCount();

	List<Task> findTasksByAssignee(String assigneeUserName);

	List<Task> findOpenTasksByAssignee(Long assigneeId);

	List<Task> findOpenTasksByAssignee(String assigneeUserName);

	List<Task> findCompletedTasksByAssignee(Long assigneeId);

	List<Task> findCompletedTasksByAssignee(String assigneeUserName);

	void completeTask(Long taskId, String comments, Long userId);

	void reassignTask(Long taskId, String comments, Long assigneeId);

	void deleteTask(Long taskId);
	
}
