package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.List;

public class IssueRepository {
    private List<Issue> issues;

    public boolean add(Issue issue) {
        return issues.add(issue);
    }



}
