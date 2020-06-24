package ru.netology.domain;

import java.util.function.Predicate;

public class IssuePredicates {

    public static Predicate<Issue> filterByAuthor(String author) {
        return p -> p.getAuthor().equalsIgnoreCase(author);
    }

    public static Predicate<Issue> filterByLabel(String label) {
        return p -> p.getLabel().toString().equalsIgnoreCase(label);
    }

    public static Predicate<Issue> filterByAssignee(String assignee) {
        return p -> p.getAssignee().toString().equalsIgnoreCase(assignee);
    }

}
