package co.za.ubuntu.ubuntubackend.controller;

import co.za.ubuntu.api.CategoryApi;
import co.za.ubuntu.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {
    /**
     * @param category Category object that needs to be added (optional)
     * @return
     */
    @Override
    public ResponseEntity<Category> createCategory(Category category) {
        return null;
    }

    /**
     * @param id id of category to delete (required)
     * @return
     */
    @Override
    public ResponseEntity<Void> deleteCategory(Long id) {
        return null;
    }

    /**
     * @param userId id of user to return categories for (required)
     * @return
     */
    @Override
    public ResponseEntity<List<Category>> getAllCategories(Long userId) {
        return null;
    }

    /**
     * @param id id of category to return (required)
     * @return
     */
    @Override
    public ResponseEntity<Category> getCategoryById(Long id) {
        return null;
    }

    /**
     * @param id       id of category to update (required)
     * @param category Category object that needs to be updated (optional)
     * @return
     */
    @Override
    public ResponseEntity<Category> updateCategory(Long id, Category category) {
        return null;
    }
}
