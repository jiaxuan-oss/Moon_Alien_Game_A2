package game.item;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ConsumeAction;

/**
 * A class that represents a GoldPot item
 * @Author: Teh Jia Xuan & Jing Yang
 */
public class GoldPot extends Item implements Consumable {
    /**
     * The balance that actor will gain when consume GoldPot
     */
    private static final int BALANCE = 10;

    /**
     * Constructor for GoldPot
     */
    public GoldPot() {
        super("Gold Pot", '$', true);
    }

    /**
     * Method to add consume action to this GoldPot
     * @param owner the actor that owns the item
     * @return a list of actions that can be performed on this GoldPot
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Method when player consume GoldPot to increase balance
     * @param actor The actor that consume the item
     * @param map The map the actor is on.
     * @return a description of the action after actor consume
     */
    @Override
    public String effect(Actor actor, GameMap map){
        actor.addBalance(BALANCE);
        actor.removeItemFromInventory(this);
        String message = String.format("%s take out %s from the pot and gains %d balance\n", actor, "Gold", BALANCE);
        message += String.format("Current balance: %s", actor.getBalance());
        return message;
    }

    /**
     * Method to get menu description of GoldPot
     * @param actor The actor that owns the item
     * @return a description of the item
     */
    @Override
    public String menuDescription(Actor actor){
        return actor + " gains " + BALANCE + " balance by taking out Gold from the pot";
    }



}
