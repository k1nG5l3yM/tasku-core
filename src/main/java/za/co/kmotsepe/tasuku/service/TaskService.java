package za.co.kmotsepe.tasuku.service;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.kmotsepe.tasuku.domain.entities.TaskEntity;
import za.co.kmotsepe.tasuku.domain.repository.TaskRepository;

/**
 *
 * @author Kingsley Motsepe
 */
@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    /**
     * 
     * @param task
     * @return 
     */
    public TaskEntity saveTask(TaskEntity task) {
        return (TaskEntity) taskRepository.save(task);
    }

    /**
     * 
     */
	public TaskEntity getTaskById(int taskId) {
		return taskRepository.findOne(taskId);
	}

    /**
     * 
     */
	public void deleteTask(int taskId) {
        taskRepository.delete(taskId);
	}

    /**
     * 
     */
	public ArrayList<TaskEntity> getAllTasks() {
        ArrayList<TaskEntity> tasks = new ArrayList<TaskEntity>();
        tasks.addAll(taskRepository.findAll()) ;

        return tasks;
	}

    /**
     * Saves TaskEntity and returns
     * 
     * @param updatedTask
     * @return updated task
     */
	public TaskEntity updateTask(TaskEntity updatedTask) {
        TaskEntity task = taskRepository.findOne(updatedTask.getId());
        BeanUtils.copyProperties(updatedTask, task);

        return task;
	}
}
