package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private List<Issue> issues = new ArrayList<>();

    public List<Issue> getAll() {
        return issues;
    }

    public boolean add(Issue issue) {
        return issues.add(issue);
    }

    public boolean remove(Issue item) {
        return issues.remove(item);
    }

    public boolean update(int id, boolean closed) {
        boolean result = false;
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                issue.setClosed(closed);
                result = true;
            }
        }
        return result;
    }
}
