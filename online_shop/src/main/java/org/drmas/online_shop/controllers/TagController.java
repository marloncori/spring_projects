package org.drmas.online_shop.controllers;

import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.models.Tag;
import org.drmas.online_shop.repositories.TagDAO;
import org.drmas.online_shop.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagDAO tagDao;

    @PostMapping("/addTagToProduct/{productId}/{tagId}")
    void addTagToProduct(@PathVariable Long productId,
                         @PathVariable Long tagId) {
        tagService.addTagToProduct(productId, tagId);
    }

    @GetMapping("/findTagsForProduct/{idProduct}")
    List<Tag> findTagsForProduct(@PathVariable Long idProduct) {
        return tagService.findTagsForProduct(idProduct);
    }

    @GetMapping("/findAllTags")
    List<Tag> findAllTags() {
        return tagService.findAllTags();
    }

    @DeleteMapping("/deleteTagFromProduct")
    void deleteTagFromProduct(@PathVariable Long idTag,
                              @PathVariable Long idProduct) {
        tagService.deleteTagFromProduct(idTag, idProduct);
    }

    @PostMapping("/addTag")
    Tag addTag(@RequestBody Tag tag) {
        return tagService.addTag(tag);
    }

    @DeleteMapping("/deleteTag/{id}")
    void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

    @GetMapping("/findTagById/{id}")
    Tag findTagById(@PathVariable Long id) {
        return tagService.findTagById(id);
    }

    @GetMapping("/findAllTagsByName/{name}")
    List<Tag> findAllTagsByName(@PathVariable String name) {
        return tagDao.findByName("%" + name + "%");
    }

    @GetMapping("/findProductsForTag/{idTag}")
    List<Product> findProductsForTag(@PathVariable Long idTag) {
        return tagService.findProductsForTag(idTag);
    }
}
