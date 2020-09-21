package com.project.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableResponse<T> {
    private List<T> content;
    private Integer pageNumber;
    private Integer size;
    private Integer totalPages;
}
