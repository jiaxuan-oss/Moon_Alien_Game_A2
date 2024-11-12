package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.Weapon.MetalPipe;
import game.actors.AlienBug;
import game.actors.Player;
import game.actors.HuntsmanSpider;
import game.actors.SuspiciousAstronaut;
import game.ground.*;
import game.item.BoltItem;
import game.item.GoldPot;
import game.item.MetalSheetItem;
import game.item.Picklejar;
import game.spawn.AlienBugSpawn;
import game.spawn.HuntsmanSpiderSpawn;
import game.spawn.SuspiciousAstronautSpawn;
import game.tree.SaplingTree;
/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Teh Jia Xuan
 * Please note that i have copilot turned on for this file
 */
public class Application {
    /**
     * The main method to start the game
     * @param args
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new ComputerTerminal());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        "..............................",
                        ".............#####............",
                        ".............#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##.........~~~",
                        ".................~~........~~~",
                        "................~~~~.......~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        gameMap.at(10,10).addActor(new HuntsmanSpider());
        gameMap.at(10,9).addActor(new AlienBug());
        gameMap.at(20,9).addActor(new SuspiciousAstronaut());
        gameMap.at(10,9).addItem(new MetalSheetItem("Metal Sheet", '%', true));
        gameMap.at(6,9).addItem(new GoldPot());
        gameMap.at(11,9).addItem(new Picklejar());
        gameMap.at(11,9).addItem(new Picklejar());
        gameMap.at(11,9).addItem(new Picklejar());
        gameMap.at(11,9).addItem(new Picklejar());
        gameMap.at(11,9).addItem(new Picklejar());

        gameMap.at(7, 9).setGround(new Crater(new HuntsmanSpiderSpawn()));
        gameMap.at(1, 10).setGround(new Crater(new AlienBugSpawn()));
        gameMap.at(4, 11).setGround(new Crater(new SuspiciousAstronautSpawn()));

        gameMap.at(12, 9).setGround(new SaplingTree());
        gameMap.at(16,8).addItem(new MetalPipe());
        gameMap.at(15, 6).addItem(new BoltItem("Bolt", '+', true));
        gameMap.at(15, 8).addItem(new BoltItem("Bolt", '+', true));
        gameMap.at(15,10).addItem(new MetalSheetItem("Metal Sheet", '%', true));


        gameMap.at(16, 6).setGround(new ComputerTerminal());
        Player player = new Player("Intern", '@', 4);
        player.addBalance(1000);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();
    }
}
