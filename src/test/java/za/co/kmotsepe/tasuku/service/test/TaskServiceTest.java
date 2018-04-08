package za.co.kmotsepe.tasuku.service.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner; //FIX-ME deprecated. this needs to be looked at

import junit.framework.TestCase;
import za.co.kmotsepe.tasuku.domain.entities.TaskEntity;
import za.co.kmotsepe.tasuku.domain.repository.TaskRepository;
import za.co.kmotsepe.tasuku.service.TaskService;

/**
 *
 * @author Kingsley Motsepe
 */
@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest extends TestCase {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskEntity task;

    ArrayList<TaskEntity> tasks;

    @Before
    @Override
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        tasks = new ArrayList<TaskEntity>();
    }

    @After
    @Override
    public void tearDown() {

    }

    @Test
    public void mock_creation_not_null() {
        assertNotNull(taskService);
        assertNotNull(taskRepository);
        assertNotNull(task);
    }

    @Test
    public void add_task_then_return_task_object() {
        task = TaskEntity.builder().name("task name").description("task description").build();

        when(taskRepository.save(task)).thenReturn(task);

        TaskEntity savedTask = taskService.saveTask(task);

        assertThat(savedTask, is(equalTo(task)));
    }

    @Test
    public void find_task_by_id() {
        when(taskRepository.findOne(5)).thenReturn(task);

        TaskEntity retrievedTask = taskService.getTaskById(5);

        assertThat(retrievedTask, is(equalTo(task)));
    }

    @Test
    public void get_all_tasks() {
        when(taskRepository.findAll()).thenReturn(tasks);

        ArrayList<TaskEntity> returnedTasks = taskService.getAllTasks();

        verify(taskRepository, times(1)).findAll();

        assertThat(returnedTasks, is(equalTo(tasks)));
    }

    @Test
    public void when_update_task_then_task_name_should_be_different() {
        task = TaskEntity.builder().id(1).name("task name").description("task description").build();

        TaskEntity updatedTask = TaskEntity.builder().id(1).name("updated name").description("task description")
                .build();

        when(taskRepository.findOne(updatedTask.getId())).thenReturn(task);

        TaskEntity returnedTask = taskService.updateTask(updatedTask);
        verify(taskRepository, times(1)).findOne(updatedTask.getId());

        assertThat(task, is(equalTo(returnedTask)));
    }

    @Test
    public void delete_task_by_id() {
        doNothing().when(taskRepository).delete(5);

        taskService.deleteTask(5);

        verify(taskRepository, times(1)).delete(5);
    }
}
