package nl.tudelft.jpacman.npc.ghost;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ClydeTest {
    private PacManSprites pacManSprites=new PacManSprites();
    private PlayerFactory playerFactory= new PlayerFactory(pacManSprites);
    ;
    private BoardFactory boardFactory=new BoardFactory(pacManSprites);
    private GhostFactory ghostFactory=new GhostFactory(pacManSprites);
    private LevelFactory levelFactory = new LevelFactory(pacManSprites,ghostFactory);
    private GhostMapParser ghostMapParser= new GhostMapParser(levelFactory,boardFactory,ghostFactory); // rajouter post tp
    @Test
    void testClyde_01() { //mauvais nom

        List<String> map= Arrays.asList(
            "###########",//nombre # pas forcement bon
            "#C#      P#",
            "###########"
        );
        Level level= ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        Optional<Direction> direction = clyde.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.empty(), direction);
    }
    @Test
    void testClyde_02() { //mauvais nom

        List<String> map= Arrays.asList(
            "################",//nombre # pas forcement bon
            "#C            P#",
            "################"
        );
        Level level= ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        Optional<Direction> direction = clyde.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        Assertions.assertEquals(Optional.of(Direction.EAST), direction);
    }
}
