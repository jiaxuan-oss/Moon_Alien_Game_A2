package game.item;

import edu.monash.fit2099.engine.items.Item;
/**
 * A class that represents a Bolt item
 * @Author: Teh Jia Xuan
 */
public class BoltItem extends Item {
    /**
     * Constructor for BoltItem
     *
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public BoltItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }
}
