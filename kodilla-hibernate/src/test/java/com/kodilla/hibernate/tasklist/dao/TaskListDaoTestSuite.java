package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {

        //Given
        TaskList taskList = new TaskList("My task", "Description of this task");
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> testDao = taskListDao.findByListName(listName);

        //Then
        assertEquals(1, testDao.size());

        //CleanUp
        int id = testDao.get(0).getId();
        taskListDao.deleteById(id);

    }
}