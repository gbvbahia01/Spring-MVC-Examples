package br.com.gbvbahia.smvc.taskify.dao;

import br.com.gbvbahia.smvc.taskify.domain.Task;
import java.util.List;


public interface TaskDAO {
	void createTask(Task task);

	Task findById(Long taskId);

	List<Task> findByAssignee(Long assigneeId);

	List<Task> findByAssignee(String assigneeUserName);

	List<Task> findAllTasks();

	int findAllTasksCount();

	List<Task> findAllOpenTasks();

	List<Task> findAllClosedTasks();

	int findAllOpenTasksCount();

	List<Task> findOpenTasksByAssignee(Long assigneeId);

	List<Task> findOpenTasksByAssignee(String assigneeUserName);

	List<Task> findClosedTasksByAssignee(Long assignee);

	List<Task> findClosedTasksByAssignee(String assigneeUserName);

	void deleteTask(Task task);

	void addFile(Long taskId, String fileName);

	void deleteFile(Long taskId, Long fileId);

	void deleteAllFiles(Long taskId);

}
