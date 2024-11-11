package br.edu.insper.af.Task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
}
