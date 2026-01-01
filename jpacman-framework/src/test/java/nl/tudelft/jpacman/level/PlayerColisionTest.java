package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.ghost.Blinky;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.GhostMapParser;
import nl.tudelft.jpacman.npc.ghost.Navigation;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.DirectColorModel;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerColisionTest {
    private PacManSprites pacManSprites = new PacManSprites();
    private PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
    private GhostFactory ghostFactory = new GhostFactory(pacManSprites);
    private LevelFactory levelFactory = new LevelFactory(pacManSprites, ghostFactory);
    private BoardFactory boardFactory = new BoardFactory(pacManSprites);
    MapParser ghostMapParser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);

    private boolean playercolisionsORDefaultplayerinteraction =false;
    private CollisionMap collisions;
    @BeforeEach
    void setColisions(){
        CollisionMap colisions;
        if (playercolisionsORDefaultplayerinteraction){
            collisions = new PlayerCollisions();
        }
        else {
            collisions = new DefaultPlayerInteractionMap();
        }
    }

    @Test
    void player_colides_with_ghost_test() {
        //before was collisions= new PlayerCollisions();
        List<String> map = Arrays.asList(
            "#############",
            "#         BP#",
            "#############"
        );

        Level level = ghostMapParser.parseMap(map);
        Player pacman = playerFactory.createPacMan();
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,level.getBoard());
        level.registerPlayer(pacman);

        assertNotNull(pacman);
        assertNotNull(blinky);
        assert(pacman.isAlive());

        collisions.collide(pacman,blinky);


        assert(!pacman.isAlive());


        
    }
    @Test
    void ghost_colides_with_player_test() {

        List<String> map = Arrays.asList(
            "#############",
            "#         BP#",
            "#############"
        );

        Level level = ghostMapParser.parseMap(map);
        Player pacman = playerFactory.createPacMan();
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,level.getBoard());
        level.registerPlayer(pacman);

        assertNotNull(pacman);
        assertNotNull(blinky);
        assert(pacman.isAlive());

        collisions.collide(blinky,pacman);


        assert(!pacman.isAlive());



    }
    @Test
    void player_colides_with_pellet_test() {

        List<String> map = Arrays.asList(
            "#############",
            "#          P#",
            "#############"
        );
        Level level = ghostMapParser.parseMap(map);
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);
        Sprite sprite = new EmptySprite();
        Pellet pellet = new Pellet(19,sprite);


        assertNotNull(pacman);
        assert(pacman.getScore()==0);
        collisions.collide(pacman,pellet);


        assert(pacman.getScore()==19);



    }
    @Test
    void ghost_colides_with_pellet_test() {

        List<String> map = Arrays.asList(
            "#############",
            "#         BP#",
            "#############"
        );
        Level level = ghostMapParser.parseMap(map);
        Blinky blinky = Navigation.findUnitInBoard(Blinky.class,level.getBoard());
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);
        Sprite sprite = new EmptySprite();
        Pellet pellet = new Pellet(19,sprite);


        assertNotNull(pacman);
        assert(pacman.getScore()==0);
        assert(pacman.isAlive());

        collisions.collide(blinky,pellet);


        assert(pacman.getScore()==0);
        assert(pacman.isAlive());
    }
}
