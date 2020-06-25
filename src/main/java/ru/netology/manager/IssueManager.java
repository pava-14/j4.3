package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueByIdComparator;
import ru.netology.domain.IssuePredicates;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class IssueManager {
    private IssueRepository repository;

    public boolean addIssue(Issue issue) {
        return repository.add(issue);
    }

    public List<Issue> getAll() {
        return repository.getAll();
    }

    private List<Issue> getIssueByStatus(boolean isClosed) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (issue.isClosed() == isClosed) {
                result.add(issue);
            }
        }
        result.sort(new IssueByIdComparator());
        return result;
    }

    public List<Issue> getClosedIssues() {
        return getIssueByStatus(true);
    }

    public List<Issue> getOpenIssues() {
        return getIssueByStatus(false);
    }

    public List<Issue> filterByAuthor(String author) {
        return repository.getAll().stream()
                .filter(IssuePredicates.filterByAuthor(author))
                .collect(Collectors.toList());
    }

    public List<Issue> filterByAssignee(String assignee) {
        return repository.getAll().stream()
                .filter(IssuePredicates.filterByLabel(assignee))
                .collect(Collectors.toList());
    }

    public List<Issue> filterByLabel(String label) {
        return repository.getAll().stream()
                .filter(IssuePredicates.filterByAssignee(label))
                .collect(Collectors.toList());
    }

    public void setIssueStatus(int id, boolean closed) {
        boolean result = repository.update(id, closed);
    }
}
