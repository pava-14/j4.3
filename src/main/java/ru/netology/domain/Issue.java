package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {
    private int id;
    private String author;
    private Set<String> label;
    private String projects;
    private String milestones;
    private Set<String> assignee;
    private boolean closed;
}

