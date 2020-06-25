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
        assertEquals(0, manager.getOpenIssues().size());
    }

    @Test
    void shouldGetClosedIssues() {
        assertEquals(0, manager.getClosedIssues().size());
    }

    @Test
    void shouldFilterByAuthor() {
        assertEquals(0, manager.filterByAuthor("sam").size());
    }

    @Test
    void filterByLabel() {
        String label = "status: invalid";
        assertEquals(0, manager.filterByLabel(label).size());
    }

    @Test
    void filterByAssignee() {
        String assignee = "smith";
        assertEquals(0, manager.filterByAssignee(assignee).size());
    }

    @Test
    void setIssueStatus() {
        manager.setIssueStatus(1, true);
        assertEquals(0, manager.getClosedIssues().size());
    }
}
