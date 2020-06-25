package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {

    private IssueManager manager = new IssueManager(new IssueRepository());
    private Set<String> label1 = new HashSet<>();
    private Set<String> label2 = new HashSet<>();
    private String assignee2 = "cartman";
    private String assignee3 = "smith";
    private String assignee4 = "vesson";
    private String assignee5 = "dolly";
    private String assignee1 = "pava-14";
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

        issue1 = new Issue(1, new Date(1592619357), "sam", label1, "project one", "2.0.0.1", assignee1, false);
        issue2 = new Issue(2, new Date(1592705757), "ronny", label2, "project two", "2.0.0.1", assignee2, true);
        issue3 = new Issue(3, new Date(1592741757), "lisa", label2, "project one", "2.0.0.1", assignee3, false);
        issue4 = new Issue(4, new Date(1592828157), "sam", label1, "project two", "2.0.0.1", assignee4, true);
        issue5 = new Issue(5, new Date(1593105357), "ronny", label1, "project one", "2.0.0.1", assignee5, true);

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
        String assignee = "smith";
        expected.add(issue3);
        expected.add(issue4);
        assertEquals(expected, manager.filterByAssignee(assignee));
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