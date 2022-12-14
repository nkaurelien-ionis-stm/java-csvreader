package com.kamitbrains.nkaurelien.ionis_stm.csvreader.contracts;

public interface CsvRowInterface {

    String get(String columnName);

    void add(String column, String value);

    void remove(String column);
}
