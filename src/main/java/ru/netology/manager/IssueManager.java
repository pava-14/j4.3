package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueManager {
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
