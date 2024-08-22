package com.yumcourt.service;

import com.yumcourt.model.Menu;
import com.yumcourt.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> retrieveMenus() {
        return menuRepository.findAll(); // Use findAll() provided by JpaRepository
    }

    public Menu getMenuById(long id) {
        Optional<Menu> menu = menuRepository.findById(id); // Use Optional to handle possible null values
        return menu.orElse(null); // Return the menu if present, otherwise return null
    }

    public void createMenu(Menu menu) {
        menuRepository.save(menu); // Use save() to create or update a menu
    }

    public void updateMenu(Menu menu) {
        menuRepository.save(menu); // save() can also be used to update
    }

    public void deleteMenu(long id) {
        menuRepository.deleteById(id); // Use deleteById() provided by JpaRepository
    }

    // You can remove this method if not needed or use it as follows:
    public Menu findMenuById(long findMenuId) {
        return getMenuById(findMenuId);
    }
}
