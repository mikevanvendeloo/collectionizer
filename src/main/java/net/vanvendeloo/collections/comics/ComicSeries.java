package net.vanvendeloo.collections.comics;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
@Builder
public class ComicSeries {
    @Id
    String id;
    String seriesName;
    String author;
    Integer inceptionYear;
    String publisher;

}
