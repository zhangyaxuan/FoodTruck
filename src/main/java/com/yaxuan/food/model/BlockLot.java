package com.yaxuan.food.model;

import com.opencsv.bean.CsvBindByName;

import java.io.Serial;
import java.io.Serializable;

public class BlockLot implements Serializable {
    @Serial
    private static final long serialVersionUID = 1171790449453504770L;
    @CsvBindByName(column = "block")
    private String block;

    @CsvBindByName(column = "lot")
    private String lot;
}
