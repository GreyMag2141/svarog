package com.example.svarog.view.objects;


import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class PrisonerView {

    private UUID id;
    private String name;
    private String sername;
    private String patronymic;
    private ZonedDateTime dateBirth;
    private String personalNumber; // № Личное дело
    private String gender; // пол

}
