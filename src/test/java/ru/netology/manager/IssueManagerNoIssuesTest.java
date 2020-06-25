package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerNoIssuesTest {
    private IssueManager manager = new IssueManager(new IssueRepository());
    private Set<String> label1 = Set.of("component: jupiter", "status: in progress", "theme: build");
    private String assignee1 = "pava-14";
    private Issue issue1;

    @BeforeEach
    public void setUp() {
        issue1 = new Issue(1, new Date(1592648107), "sam", label1, "project one", "2.0.0.1", assignee1, false);
    }

    @Test
    void shouldAddIssue() {
        List<Issue> expected = Arrays.asList(issue1);
        manager.addIssue(issue1);
        assertEquals(expected, manager.getAll());
    }

    @Test
    void shouldGetOpenIssues() {
        List<Issue> expected = Arrays.asList();
        assertEquals(expected, manager.getOpenIssues());
    }

    @Test
    void shouldGetClosedIssues() {
        List<Issue> expected = Arrays.asList();
        assertEquals(expected, manager.getClosedIssues());
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> expected = Arrays.asList();
        assertEquals(expected, manager.filterByAuthor("sam"));
    }

    @Test
    void filterByLabel() {
        List<Issue> expected = Arrays.asList();
        String label = "status: invalid";
        assertEquals(expected, manager.filterByLabel(label));
    }

    @Test
    void filterByAssignee() {
        List<Issue> expected = Arrays.asList();
        String assignee = "smith";
        assertEquals(expected, manager.filterByAssignee(assignee));
    }

    @Test
    void setIssueStatus() {
        List<Issue> expected = Arrays.asList();
        manager.setIssueStatus(1, true);
        assertEquals(expected, manager.getClosedIssues());
    }
}
