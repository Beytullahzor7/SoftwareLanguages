package com.languages.dataAccess.abstracts;

import com.languages.entities.concretes.SoftwareLanguages;

import java.util.List;

public interface LanguagesRepository {

    SoftwareLanguages add(SoftwareLanguages softwareLanguages);

    void delete(int id);

    SoftwareLanguages update(int id, SoftwareLanguages softwareLanguages);

    List<SoftwareLanguages> list();

    SoftwareLanguages getById(int id);

}
