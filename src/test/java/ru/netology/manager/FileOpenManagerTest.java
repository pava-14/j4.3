package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOpenManagerTest {

    private FileOpenManager manager;

    @BeforeEach
    public void setUp() {
        manager = new FileOpenManager(new HashMap<>());
        manager.registerExt(".docx", "Microsoft Word");
        manager.registerExt(".xlsx", "Microsoft Excel");
        manager.registerExt(".pdf", "Acrobat Reader");
    }

    @Test
    public void shouldGetAllExt() {
        List<String> expected = Arrays.asList(".docx", ".pdf", ".xlsx");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldGetListAllApp() {
        List<String> expected = Arrays.asList("Acrobat Reader", "Microsoft Excel", "Microsoft Word");
        assertEquals(expected, manager.getAllApp());
    }

    @Test
    public void shouldRegisterExtIfNotExists() {
        manager.registerExt(".docx", "Microsoft Word");
        List<String> expected = Arrays.asList(".docx", ".pdf", ".xlsx");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldRegisterExtIfExists() {
        manager.registerExt(".txt", "Notepad");
        List<String> expected = Arrays.asList(".docx", ".pdf", ".txt", ".xlsx");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldRegisterExtUpperCaseIfExists() {
        manager.registerExt(".TXT", "Notepad");
        List<String> expected = Arrays.asList(".docx", ".pdf", ".txt", ".xlsx");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldGetAppByExt() {
        String expected = "Microsoft Word";
        assertTrue(expected.equalsIgnoreCase(manager.getAppByExt(".docx")));
    }

    @Test
    public void shouldGetAppByExtUpperCase() {
        String expected = "Microsoft Word";
        assertTrue(expected.equalsIgnoreCase(manager.getAppByExt(".DOCX")));
    }

    @Test
    public void shouldUnregisterExtIfExixsts() {
        List<String> expected = Arrays.asList(".pdf", ".xlsx");
        manager.unregisterExt(".docx");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldUnregisterExtUpperCaseIfExixsts() {
        List<String> expected = Arrays.asList(".pdf", ".xlsx");
        manager.unregisterExt(".DOCX");
        assertEquals(expected, manager.getAllExt());
    }

    @Test
    public void shouldUnregisterExtIfNotExixsts() {
        List<String> expected = Arrays.asList(".docx", ".pdf", ".xlsx");
        manager.unregisterExt(".pptx");
        assertEquals(expected, manager.getAllExt());
    }
}