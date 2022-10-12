package org.rustem.service;

import lombok.extern.slf4j.Slf4j;
import org.rustem.model.Stack;
import org.rustem.model.Task;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskService {

    public Task findmaxword(Task task){
        String[] arrword=task.getText().split(" ");
        int max_length=0;
        String max_word="";
        Stack stack=null;
        for (String word: arrword){
            if (max_length<word.length()){
                max_length=word.length();
                max_word=word;
            }
            if (stack==null){
                stack=new Stack(word, null);
            }else{
                stack.setNext(new Stack(word, null));
                stack=stack.getNext();
            }
        }

        while(stack!=null){
            log.info("word={}",stack.getText());
        }

        task.setWord(max_word);

        return task;
    }
}
