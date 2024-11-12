package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.*;
import game.item.DragonSlayerSword;
import game.item.EnergyDrink;
import game.item.ToiletPaperRoll;

/**
 * A class that represents a Computer Terminal that allows the player to purchase items.
 *
 * @author Lee Quan Hong
 */
public class ComputerTerminal extends Ground {

    /**
     * Constructor for Computer Terminal.
     */
    public ComputerTerminal() {
        super('=');
    }

    /**
     * Returns the allowable actions that the player can perform on the Computer Terminal.
     * @param actor the actor that is performing the action
     * @param location the location of the Computer Terminal
     * @param direction the direction of the actor
     * @return an ActionList containing the allowable actions that the player can perform on the Computer Terminal
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();

        // Add the actions that the player can perform on the Computer Terminal
        actions.add(new PurchaseAction(new ToiletPaperRoll()));
        actions.add(new PurchaseAction(new EnergyDrink()));
        actions.add(new PurchaseAction(new DragonSlayerSword()));

        return actions;
    }
}
