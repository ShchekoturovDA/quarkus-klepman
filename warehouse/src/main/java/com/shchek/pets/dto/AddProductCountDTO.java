package com.shchek.pets.dto;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

@Data
public class AddProductCountDTO {
    List<Pair<String, Long>> productsCounts;
}
