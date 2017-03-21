package net.vanvendeloo.collections.comics;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
@Builder
public class Comic {

    @Id
    private String id;
    private String title;
    private String description;
    private String issueNumber;

}
