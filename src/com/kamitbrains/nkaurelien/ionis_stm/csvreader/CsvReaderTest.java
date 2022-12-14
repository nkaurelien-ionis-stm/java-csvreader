package com.kamitbrains.nkaurelien.ionis_stm.csvreader;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    private static final String MY_FILE = "assets\\test_1.csv";
    private Csv csv;

    @BeforeEach
    void beforeEachTestCase() {
        csv = new Csv(MY_FILE);
    }

    @Test
    void testRemoveCellInRow() {
        csv.getRows().get(2).remove("city");
        assertNull(csv.getRows().get(2).get("city"));
    }


    @Test
    void testRow() {
        assertEquals(3, csv.getRows().size());
        assertEquals("new york", csv.getRows().get(2).get("city").toLowerCase());
        assertEquals("new york", csv.getRow(2).get("city").toLowerCase());
        assertTrue(csv.getRow(2).values().contains("New York"));
        assertTrue(csv.getRow(2).toString().contains("New York"));
    }

    @Test
    void testHeader() {
        assertTrue(csv.getHeader().contains("city"));
        assertTrue(csv.getHeader().contains("name"));
        assertTrue(csv.getHeader().contains("age"));
    }


    @Test
    void testCustomConfig() {

        CsvFileConfig config = new CsvFileConfig(true, 1, ',');
        Csv csv = new Csv(MY_FILE, config);

        assertEquals(2, csv.getRows().size());
        assertEquals("toto", csv.getHeader().get(0).toLowerCase());
        assertEquals("15", csv.getHeader().get(1).toLowerCase());
        assertEquals("paris", csv.getHeader().get(2).toLowerCase());

    }


}
