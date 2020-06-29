package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
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
        result.sort((o1, o2) -> o1.getId() - o2.getId());
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
                .filter((p) -> p.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Issue> filterByAssignee(String assignee) {
        return repository.getAll().stream()
                .filter((p) -> p.getAssignee().equalsIgnoreCase(assignee))
                .collect(Collectors.toList());
    }

    public List<Issue> filterByLabel(String label) {
        return repository.getAll().stream()
                .filter((p) -> p.getLabel().contains(label))
                .collect(Collectors.toList());
    }

    public void setIssueStatus(int id, boolean closed) {
        repository.update(id, closed);
    }
}
