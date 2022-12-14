package com.kamitbrains.nkaurelien.ionis_stm.csvreader;

import com.kamitbrains.nkaurelien.ionis_stm.csvreader.contracts.CsvFileInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Csv implements CsvFileInterface {

    private List<String> fileLines;

    private String path;
    private List<Row> rows = new ArrayList<>();
    private CsvFileConfig config;
    private List<String> header;

    public Csv(String path, CsvFileConfig config) {
        this.path = path;
        this.config = config;
        parse(path, config);
    }

    public Csv(String path) {
        this.path = path;
        parse(path);
    }

    public void parse(String path) {
        CsvFileConfig defaultCsvFileConfig = new CsvFileConfig();
        parse(path, defaultCsvFileConfig);
    }

    public void parse(String path, CsvFileConfig csvFileConfiguration) {
        this.path = path;
        this.config = csvFileConfiguration;
        try {
            fileLines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        build();
    }

    public void build() {
        if (!fileLines.isEmpty()) {
            if (config.hasFirstHeaderLine) {
                String[] headerCells = fileLines.get(config.firstHeaderLineNumber).split(String.valueOf(config.separator));
                header = Arrays.asList(headerCells);
                List<String> rowsLines = fileLines.subList(config.firstHeaderLineNumber + 1, fileLines.size());

                for (int i = 0; i < rowsLines.size(); i++) {
                    Row row = Row.build(header, rowsLines.get(i), config.separator);
                    rows.add(i, row);
                }
            }
        }
    }


    @Override
    public List<String> getHeader() {
        return header;
    }

    @Override
    public Row getRow(int i) {
        return i < rows.size() ? rows.get(i) : null;
    }

    @Override
    public List<Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Nombre de lignes " + header.size() + "\n");
        s.append(header).append("\n");
        for (Row line : this.rows) {
            s.append(line.values()).append("\n");

        }
        return s.toString();
    }
}
