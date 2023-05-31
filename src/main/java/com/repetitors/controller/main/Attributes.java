package com.repetitors.controller.main;

import com.repetitors.model.enums.Category;
import com.repetitors.model.enums.Role;
import com.repetitors.model.enums.Type;
import org.springframework.ui.Model;

public class Attributes extends Main {

    protected void AddAttributes(Model model) {
        model.addAttribute("role", getRole());
        model.addAttribute("user", getUser());
    }

    protected void AddAttributesEnums(Model model) {
        model.addAttribute("categories", Category.values());
        model.addAttribute("types", Type.values());
    }

    protected void AddAttributesUsers(Model model) {
        AddAttributes(model);
        model.addAttribute("users", usersRepo.findAll());
        model.addAttribute("roles", Role.values());
    }

    protected void AddAttributesAd(Model model, Long id) {
        AddAttributes(model);
        model.addAttribute("ad", adsRepo.getReferenceById(id));
    }

    protected void AddAttributesAdAdd(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
    }

    protected void AddAttributesAdEdit(Model model, Long id) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("ad", adsRepo.getReferenceById(id));
    }

    protected void AddAttributesIndex(Model model) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("ads", adsRepo.findAll());
    }

    protected void AddAttributesAdMy(Model model) {
        AddAttributes(model);
        model.addAttribute("ads", getUser().getAds());
    }


    protected void AddAttributesIndexSearch(Model model, String search, Category category, Type type) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("bSelect", category);
        model.addAttribute("fSelect", type);
        model.addAttribute("search", search);
        model.addAttribute("ads", adsRepo.findAllByNameContainingAndDescription_CategoryAndDescription_Type(search, category, type));
    }

    protected void AddAttributesIndexSearchCategory(Model model, Category category) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("bSelect", category);
        model.addAttribute("ads", adsRepo.findAllByDescription_Category(category));
    }

    protected void AddAttributesIndexSearchType(Model model, Type type) {
        AddAttributes(model);
        AddAttributesEnums(model);
        model.addAttribute("fSelect", type);
        model.addAttribute("ads", adsRepo.findAllByDescription_Type(type));
    }

    protected void AddAttributesStats(Model model) {
        AddAttributes(model);
        model.addAttribute("reps", usersRepo.findAllByRole(Role.MANAGER));
    }
}
