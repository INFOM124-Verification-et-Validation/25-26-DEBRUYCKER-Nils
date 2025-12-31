package nl.tudelft.jpacman.npc.ghost;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class InkyTest {
    private PacManSprites pacManSprites=new PacManSprites();
    private PlayerFactory playerFactory= new PlayerFactory(pacManSprites);
    ;
    private BoardFactory boardFactory=new BoardFactory(pacManSprites);
    private GhostFactory ghostFactory=new GhostFactory(pacManSprites);
    private LevelFactory levelFactory = new LevelFactory(pacManSprites,ghostFactory);
    private GhostMapParser ghostMapParser= new GhostMapParser(levelFactory,boardFactory,ghostFactory); // rajouter post tp

    @Test
    public void inkyTestNoPossibleMovement(){
        List<String> map= Arrays.asList(
            "###########",//nombre # pas forcement bon
            "#I#  B   P#",
            "###########"
        );
        Level level= ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Inky inky= Navigation.findUnitInBoard(Inky.class, level.getBoard());
        Optional<Direction> direction = inky.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.empty(), direction);

    }

    @Test
    public void inkyTestEastmove() {
        List<String> map = Arrays.asList(
            "###########",//nombre # pas forcement bon
            "#I    P  B#",
            "###########"
        );
        Level level = ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        Optional<Direction> direction = inky.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.of(Direction.EAST), direction);
    }

    @Test
    public void inkyTestSouthBlinky() {
        List<String> map = Arrays.asList(
            "###########",
            "#         #",//nombre # pas forcement bon
            "#I#      P#",
            "#     B   #",
            "###########"
        );
        Level level = ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        Optional<Direction> direction = inky.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.of(Direction.NORTH), direction);
    }

    @Test
    public void inkyPathToOutOfBound() {
        List<String> map = Arrays.asList(
            "###########",
            "#        ##",//nombre # pas forcement bon
            "#B  I    P#",
            "#        ##",
            "###########"
        );
        Level level = ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        Optional<Direction> direction = inky.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.of(Direction.EAST), direction); //rate mais compertement dans ce cas est non défini
    }

    @Test
    public void inkyPathWallAsFinalDestination() {
        List<String> map = Arrays.asList(
            "###########",
            "#B P   ## #",//nombre # pas forcement bon
            "#   I     #",
            "#         #",
            "###########"
        );
        Level level = ghostMapParser.parseMap(map); //editer post tp
        Player pacman = playerFactory.createPacMan();
        level.registerPlayer(pacman);

        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        Optional<Direction> direction = inky.nextAiMove();
        //assert direction.eqals(Optional.ofDirection.East)
        assertEquals(Optional.of(Direction.EAST), direction); //rate mais compertement dans ce cas est non défini
    }
}
