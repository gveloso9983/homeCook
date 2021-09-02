package com.example.homecookBackend.beans;

import com.example.homecookBackend.classes.category.Category;
import com.example.homecookBackend.classes.category.CategoryDAO;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;

@Service
public class category_perfil {
    public static Category[] list() throws PersistentException {
        Category[] res = CategoryDAO.listCategoryByQuery(null,null);
        return res;
    }
}
