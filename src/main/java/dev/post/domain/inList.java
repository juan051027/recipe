package dev.post.domain;

import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class inList {
    @Convert(converter = ListStringConverter.class)
    private List<String> inList;
}
