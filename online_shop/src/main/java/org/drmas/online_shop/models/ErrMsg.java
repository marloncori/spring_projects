package org.drmas.online_shop.models;

import org.springframework.stereotype.Component;

@Component
public class ErrMsg {

    private String userAbsent = "User has not been found in database!";
    private String cartAbsent =  "Cart has not been found in database!";
    private String categoryAbsent =  "Requested category does not exit in database!";
    private String productAbsent =  "Requested product does not exit in database!";
    private String commentAbsent =  "Comment has not been found in database!";
    private String ordersAbsent =  "Orders have not been found in database!";
    private String tagAbsent =  "Tag has not been found in database!";

    private String userIdFail = "Please provide a valid USER ID!";
    private String cartIdFail = "Please provide a valid CART ID!";
    private String categoryIdFail = "PLease enter a valid category ID!";
    private String productIdFail = "PLease enter a valid product ID!";
    private String commentIdFail = "PLease enter a valid comment ID!";
    private String tagIdFail = "PLease enter a valid TAG ID!";

    private String cartMsgFail = "Cart information cannot be null!";
    private String userMsgFail = "User information has not be given!";
    private String categoryMsgFail = "Please provide category information!";
    private String productMsgFail = "Please provide required product information!";
    private String commentMsgFail = "Please provide required comment information - it cannot be null!";
    private String tagMsgFail = "Please provide required TAG information - it cannot be null!";

    private String UserNameEmpty = "Please provide a user name!";
    private String CartNameEmpty = "Please provide a cart name!";

    public String getUserAbsent() {
        return userAbsent;
    }

    public String getCartAbsent() {
        return cartAbsent;
    }

    public String getUserIdFail() {
        return userIdFail;
    }

    public String getCartIdFail() {
        return cartIdFail;
    }

    public String getCartMsgFail() {
        return cartMsgFail;
    }

    public String getUserMsgFail() {
        return userMsgFail;
    }

    public String getUserNameEmpty() {
        return UserNameEmpty;
    }

    public String getCartNameEmpty() {
        return CartNameEmpty;
    }

    public String getCategoryAbsent() {
        return categoryAbsent;
    }

    public String getCategoryIdFail() {
        return categoryIdFail;
    }

    public String getCategoryMsgFail() {
        return categoryMsgFail;
    }

    public String getProductAbsent() {
        return productAbsent;
    }

    public String getProductIdFail() {
        return productIdFail;
    }

    public String getProductMsgFail() {
        return productMsgFail;
    }

    public String getCommentMsgFail() {
        return commentMsgFail;
    }

    public String getCommentAbsent() {
        return commentAbsent;
    }

    public String getCommentIdFail() {
        return commentIdFail;
    }

    public String getOrdersAbsent() {
        return ordersAbsent;
    }

    public String getTagAbsent() {
        return tagAbsent;
    }

    public String getTagIdFail() {
        return tagIdFail;
    }

    public String getTagMsgFail() {
        return tagMsgFail;
    }
}
