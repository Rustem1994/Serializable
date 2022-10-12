package org.rustem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.rustem.model.Task;
import org.rustem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiTask {

    @Autowired
    TaskService taskService;

    @PostMapping(path = "hello")
    public String setGroup(@RequestBody Task taskDto) {
        log.info("Task {}",taskDto);
        taskService.findmaxword(taskDto);
        return taskDto.toString();
    }
}
