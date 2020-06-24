package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {

    private IssueManager manager = new IssueManager();
    private Set<String> label1 = new HashSet<>();
    private Set<String> label2 = new HashSet<>();
    private Set<String> assignee1 = new HashSet<>();
    private Set<String> assignee2 = new HashSet<>();
    private Issue issue1;
    private Issue issue2;
    private Issue issue3;
    private Issue issue4;
    private Issue issue5;

    @BeforeEach
    public void setUp() {
        label1.add("component: jupiter");
        label1.add("status: in progress");
        label1.add("theme: build");
        label2.add("component: kotlin");
        label2.add("status: invalid");

        assignee1.add("pava-14");
        assignee1.add("cartman");
        assignee2.add("smith");
        assignee2.add("vesson");
        assignee2.add("dolly");

        issue1 = new Issue(1, "sam", label1, "project one", "2.0.0.1", assignee1, false);
        issue2 = new Issue(2, "ronny", label2, "project two", "2.0.0.1", assignee1, true);
        issue3 = new Issue(3, "lisa", label2, "project one", "2.0.0.1", assignee2, false);
        issue4 = new Issue(4, "sam", label1, "project two", "2.0.0.1", assignee2, true);
        issue5 = new Issue(5, "ronny", label1, "project one", "2.0.0.1", assignee2, true);

        manager.addIssue(issue1);
        manager.addIssue(issue2);
        manager.addIssue(issue3);
        manager.addIssue(issue4);
    }

    @Test
    void shouldAddIssue() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue2);
        expected.add(issue3);
        expected.add(issue4);
        expected.add(issue5);

        manager.addIssue(issue5);
        assertEquals(expected, manager.getAll());
    }

    @Test
    void shouldGetOpenIssues() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue3);

        assertEquals(expected, manager.getOpenIssues());
    }

    @Test
    void shouldGetClosedIssues() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue4);
        assertEquals(expected, manager.getClosedIssues());
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue4);
        assertEquals(expected, manager.filterByAuthor("sam"));
    }

    @Test
    void filterByLabel() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue2);
        expected.add(issue3);
        assertEquals(expected, manager.filterByLabel(label2.toString()));
    }

    @Test
    void filterByAssignee() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue3);
        expected.add(issue4);
        assertEquals(expected, manager.filterByAssignee(assignee2.toString()));
    }

    @Test
    void setIssueStatus() {
        List<Issue> expected = new ArrayList<>();
        expected.add(issue1);
        expected.add(issue2);
        expected.add(issue4);
        manager.setIssueStatus(1, true);
        assertEquals(expected, manager.getClosedIssues());
    }
}