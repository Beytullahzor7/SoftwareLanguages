package com.languages.business.abstracts;

import com.languages.entities.concretes.SoftwareLanguages;

import java.util.List;

public interface LanguagesService {

    SoftwareLanguages add(SoftwareLanguages softwareLanguages);

    void delete(int id);

    SoftwareLanguages update(int id, SoftwareLanguages softwareLanguages);

    List<SoftwareLanguages> list();

    SoftwareLanguages getById(int id);
}
