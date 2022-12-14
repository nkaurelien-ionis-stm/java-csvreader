package com.kamitbrains.nkaurelien.ionis_stm.csvreader.contracts;

import com.kamitbrains.nkaurelien.ionis_stm.csvreader.Row;

import java.util.List;

public interface CsvFileInterface {
    public List<String> getHeader();

    public Row getRow(int i);

    public List<Row> getRows();
}
