package br.edu.insper.af.Task;

import br.edu.insper.af.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

// REFERENCIA: https://howtodoinjava.com/spring-boot2/resttemplate/resttemplate-get-example/ + https://stackoverflow.com/questions/43900699/resttemplate-getforentity-pass-headers + https://attacomsian.com/blog/spring-boot-resttemplate-get-request-parameters-headers

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public User verifyUserToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity request = new HttpEntity(headers);

        try {
            ResponseEntity<User> response = restTemplate.exchange("http://184.72.80.215/usuario/validate", HttpMethod.GET, request, User.class);

            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public Task createTask(Task task, String token) {
        User user = verifyUserToken(token);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }

        if (!user.getPapel().equals("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário não é administrador");
        }

        return taskRepository.save(task);
    }

    public void deleteTask(String id, String token) {
        User user = verifyUserToken(token);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }

        if (!user.getPapel().equals("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Usuário não é administrador");
        }

        taskRepository.deleteById(id);
    }

    public Task getSpecificTask(String id, String token) {
        User user = verifyUserToken(token);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }

        return taskRepository.findById(id).orElse(null);
    }

    public ArrayList<Task> getTasks(String token) {
        User user = verifyUserToken(token);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }

        return (ArrayList<Task>) taskRepository.findAll();
    }
}
