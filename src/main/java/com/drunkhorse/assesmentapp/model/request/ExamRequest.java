package com.drunkhorse.assesmentapp.model.request;

import com.drunkhorse.assesmentapp.model.ExamTag;
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
public class ExamRequest {

    private Long id;
    private List<ExamTag> tags;

}
