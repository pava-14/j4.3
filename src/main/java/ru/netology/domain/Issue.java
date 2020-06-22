package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue<label> {
    private int id;
    private String author;
    private String label;
    private String projects;
    private String milestones;
    private String assignee;
    private boolean closed;
}
