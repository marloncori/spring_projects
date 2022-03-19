package org.drmas.online_shop.services;

import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.models.Tag;

import java.util.List;

public interface TagService {

    void addTagToProduct(Long idProduct, Long idTag);
    List<Tag> findTagsForProduct(Long idProduct);
    List<Tag> findAllTags();
    void deleteTagFromProduct(Long idTag, Long idProduct);
    Tag addTag(Tag tag);
    void deleteTag(Long id);
    Tag findTagById(Long id);
    List<Product> findProductsForTag(Long idTag);

}
