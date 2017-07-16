package br.com.gbvbahia.smvc.taskify.service;

import br.com.gbvbahia.smvc.taskify.domain.Task;
import java.util.List;


public interface TaskService {
	Task createTask(String name, int priority, int createdByuserId, int assigneeUserId);
	Task findTaskById(int taskId);
	List<Task> findTasksByAssignee(int assigneeId);
	List<Task> findAllTasks();
	int findAllTasksCount();
	List<Task> findAllOpenTasks();
	int findAllOpenTasksCount();
	List<Task> findTasksByAssignee(String assigneeUserName);
	List<Task> findOpenTasksByAssignee(int assigneeId);
	List<Task> findOpenTasksByAssignee(String assigneeUserName);
	
	void completeTask(int taskId, String comments, int user);
}
