package com.languages.dataAccess.concretes;

import com.languages.dataAccess.abstracts.LanguagesRepository;
import com.languages.entities.concretes.SoftwareLanguages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguagesRepository {
    List<SoftwareLanguages> languagesList;

    public InMemoryLanguageRepository() {
        languagesList = new ArrayList<>();
        languagesList.add(new SoftwareLanguages(1, "Java"));
        languagesList.add(new SoftwareLanguages(2, "C#"));
        languagesList.add(new SoftwareLanguages(3, "Python"));
        languagesList.add(new SoftwareLanguages(4, "Javascript"));
        languagesList.add(new SoftwareLanguages(5, "Kotlin"));
    }

    @Override
    public SoftwareLanguages add(SoftwareLanguages softwareLanguages) {
        languagesList.add(softwareLanguages);
        return softwareLanguages;
    }

    @Override
    public void delete(int id) {
        languagesList.remove(getById(id));
    }

    @Override
    public SoftwareLanguages update(int id, SoftwareLanguages softwareLanguages) {
        SoftwareLanguages updatedLanguage = getById(id);
        languagesList.set(languagesList.indexOf(updatedLanguage), softwareLanguages);
        return softwareLanguages;
    }

    @Override
    public List<SoftwareLanguages> list() {
        return languagesList;
    }

    @Override
    public SoftwareLanguages getById(int id) {
        return languagesList.stream().filter(i -> i.getId() == id).findAny().get();
    }
}
