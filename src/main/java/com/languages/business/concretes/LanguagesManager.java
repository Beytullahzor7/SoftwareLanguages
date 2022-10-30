package com.languages.business.concretes;

import com.languages.business.abstracts.LanguagesService;
import com.languages.dataAccess.abstracts.LanguagesRepository;
import com.languages.entities.concretes.SoftwareLanguages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguagesManager implements LanguagesService {

    private LanguagesRepository repository;

    public LanguagesManager(LanguagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public SoftwareLanguages add(SoftwareLanguages softwareLanguages) {
        isIdGreaterThanZero(softwareLanguages.getId());
        String name = softwareLanguages.getName();
        isLanguageNameRepeated(name);
        isLanguageNameNullOrBlank(name);
        return repository.add(softwareLanguages);
    }

    @Override
    public void delete(int id) {
        isIdValid(id);
        repository.delete(id);
    }

    @Override
    public SoftwareLanguages update(int id, SoftwareLanguages softwareLanguages) {
        isIdValid(id);
        isLanguageNameRepeated(softwareLanguages.getName());
        isLanguageNameNullOrBlank(softwareLanguages.getName());
        return repository.update(id, softwareLanguages);
    }

    @Override
    public List<SoftwareLanguages> list() {
        return repository.list();
    }

    @Override
    public SoftwareLanguages getById(int id) {
        isIdValid(id);
        return repository.getById(id);
    }

    private void isLanguageNameRepeated(String name) {
        boolean result = repository.list().stream().anyMatch(i -> i.getName().equals(name));
        if (result) {
            throw new RuntimeException("This " + name + " is already exists!");
        }
    }

    private void isLanguageNameNullOrBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new RuntimeException(name + "can not be null or empty!");
        }
    }

    private void isIdValid(int id) {
        repository.list()
                .stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("This " + id + "is already exists!"));
    }

    private void isIdGreaterThanZero(int id) {
        if (id <= 0) {
            throw new RuntimeException("Id must be greater than 0!");
        }
    }
}
