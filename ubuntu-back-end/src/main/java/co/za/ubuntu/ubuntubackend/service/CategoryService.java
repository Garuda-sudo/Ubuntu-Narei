package co.za.ubuntu.ubuntubackend.service;

import co.za.ubuntu.model.Category;

/**
 * Service interface for managing categories.
 * <p>
 * This service provides methods to interact with categories, including creating, retrieving,
 * updating, and deleting categories.
 *
 * @since 0.0.1
 */
public interface CategoryService {

    /**
     * Creates a new category.
     *
     * @param category The category object to create.
     * @return The created category object.
     */
    Category createCategory(Category category);

    /**
     * Deletes a category by its unique identifier.
     *
     * @param id The unique identifier of the category to delete.
     */
    void deleteCategory(Long id);

    /**
     * Retrieves a category by its unique identifier.
     *
     * @param id The unique identifier of the category to retrieve.
     * @return The category object if found; otherwise, null.
     */
    Category getCategoryById(Long id);

    /**
     * Updates an existing category.
     *
     * @param id The unique identifier of the category to update.
     * @param category The updated category object to save.
     * @return The updated category object.
     */
    Category updateCategory(Long id, Category category);
}
