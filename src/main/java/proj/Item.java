package proj;

import java.util.List;

public class Item {

    String itemId;
    String name;
    Integer quantity;
    List<Modifiers>modifiers;

    public List<Modifiers> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifiers> modifiers) {
        this.modifiers = modifiers;
    }



    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }




}
