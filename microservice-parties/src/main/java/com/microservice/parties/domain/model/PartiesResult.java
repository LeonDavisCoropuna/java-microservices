package com.microservice.parties.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "election-result")
@Builder
public class PartiesResult {
    @Id
    private String id;
    private Date date;
    private List<PoliticalPartiesResut> parties;
}
