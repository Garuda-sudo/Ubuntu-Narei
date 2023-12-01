package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Category;
import co.za.ubuntu.ubuntubackend.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * @param category The category object to create.
     * @return
     */
    @Override
    public Category createCategory(Category category) {
        return null;
    }

    /**
     * @param id The unique identifier of the category to delete.
     */
    @Override
    public void deleteCategory(Long id) {

    }

    /**
     * @param id The unique identifier of the category to retrieve.
     * @return
     */
    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    /**
     * @param id       The unique identifier of the category to update.
     * @param category The updated category object to save.
     * @return
     */
    @Override
    public Category updateCategory(Long id, Category category) {
        return null;
    }
}
