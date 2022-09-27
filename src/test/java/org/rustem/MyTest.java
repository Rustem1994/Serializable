package org.rustem;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rustem.model.Task;

import java.io.*;

@Slf4j
public class MyTest {

    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Task task = Task.builder().name("TEST").status("ON").build();
        log.info("tast={}",task);
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(task);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Task task1 = (Task)  objectInputStream.readObject();
        log.info("task1={}",task1);
        Assertions.assertTrue(task1.equals(task));
        Assertions.assertFalse(task1.equals(task));

      /*  Assertions.assertEquals("TEST",task.getName());*/
    }

    @Test
    public void testWriteObject() throws IOException, ClassNotFoundException {
        Task task = Task.builder().name("TEST").status("ON").build();
        log.info("tast={}",task);
        FileOutputStream outputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(task);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();

        Assertions.assertEquals("TEST",task.getName());
    }

    @Test
    public void testReadObject() throws IOException, ClassNotFoundException {
        Task task = Task.builder().name("TEST").status("ON").build();
        log.info("task={}",task);

        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Task task1 = (Task)  objectInputStream.readObject();
        log.info("task1={}",task1);

        Assertions.assertEquals(task,task1);
    }
}
