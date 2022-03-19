package org.drmas.online_shop.implementations;

import org.drmas.online_shop.exception.ResourceNotFoundException;
import org.drmas.online_shop.models.ErrMsg;
import org.drmas.online_shop.models.Product;
import org.drmas.online_shop.models.Tag;
import org.drmas.online_shop.repositories.ProductDAO;
import org.drmas.online_shop.repositories.TagDAO;
import org.drmas.online_shop.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDao;

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private ErrMsg errMsg;

    @Override
    public void addTagToProduct(Long idProduct, Long idTag) {
        if(idTag == null){
            throw new IllegalArgumentException(errMsg.getTagIdFail());
        }
        if(idProduct == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> product = productDao.findById(idProduct);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        Optional<Tag> tag = tagDao.findById(idTag);
        if(tag.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        tag.get().addProductToTag(product.get());
        product.get().addTag(tag.get());
    }

    @Override
    public List<Tag> findTagsForProduct(Long idProduct) {
        if(idProduct == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> product = productDao.findById(idProduct);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        return product.get().getTags();
    }

    @Override
    public void deleteTagFromProduct(Long idTag, Long idProduct) {
        if(idTag == null){
            throw new IllegalArgumentException(errMsg.getTagIdFail());
        }
        if(idProduct == null){
            throw new IllegalArgumentException(errMsg.getProductIdFail());
        }
        Optional<Product> product = productDao.findById(idProduct);
        if(product.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getProductAbsent());
        }
        Optional<Tag> tag = tagDao.findById(idTag);
        if(tag.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        product.get().getTags().remove(tag.get());
    }

    @Override
    public Tag addTag(Tag tag) {
        if(tag == null){
            throw new IllegalArgumentException(errMsg.getTagMsgFail());
        }
        return tagDao.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getTagIdFail());
        }
        Optional<Tag> maybeTag = tagDao.findById(id);
        if(maybeTag.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        tagDao.deleteById(maybeTag.get().getId());
    }

    @Override
    public Tag findTagById(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getTagIdFail());
        }
        Optional<Tag> maybeTag = tagDao.findById(id);
        if(maybeTag.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        return maybeTag.get();
    }

    @Override
    public List<Tag> findAllTags() {
        Optional<List<Tag>> allTags =
                Optional.ofNullable(tagDao.findAll());
        if(allTags.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        return allTags.get();
    }

    @Override
    public List<Product> findProductsForTag(Long id) {
        if(id == null){
            throw new IllegalArgumentException(errMsg.getTagIdFail());
        }
        Optional<Tag> maybeTag = tagDao.findById(id);
        if(maybeTag.isEmpty()){
            throw new ResourceNotFoundException(errMsg.getTagAbsent());
        }
        return maybeTag.get().getProducts();
    }

}
