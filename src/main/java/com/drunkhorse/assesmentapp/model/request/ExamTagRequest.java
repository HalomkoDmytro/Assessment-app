package com.drunkhorse.assesmentapp.model.request;

import com.drunkhorse.assesmentapp.model.dto.Paging;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ExamTagRequest {

    private List<String> tags;

    private Paging pagging;
}
