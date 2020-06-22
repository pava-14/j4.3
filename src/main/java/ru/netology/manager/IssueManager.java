package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueManager {
    private Set<String> labels;
    private Set<String> projects;
    private Set<String> milestones;
    private Set<String> assignees;
    private IssueRepository repository;

    public boolean addIssue(Issue issue) {
        return repository.add(issue);
    }

    public List<Issue> getClosedIssues() {
        return null;
    }

    public List<Issue> getOpenIssues() {
        return null;
    }
}
