package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.google.common.collect.Lists;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // TODO
        assert(! unit.hasSquare());
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // TODO
        PacManSprites sprites = new PacManSprites();
        MapParser parser = new MapParser(new LevelFactory(sprites, new GhostFactory(
            sprites)), new BoardFactory(sprites));
        Board board = parser.parseMap(Lists.newArrayList("####", "#  #", "####")).getBoard();

        unit.occupy(board.squareAt(1, 2));
        assertThat(unit.getSquare()).isEqualTo(board.squareAt(1, 2));
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // TODO
        PacManSprites sprites = new PacManSprites();
        MapParser parser = new MapParser(new LevelFactory(sprites, new GhostFactory(
            sprites)), new BoardFactory(sprites));
        Board board = parser.parseMap(Lists.newArrayList("####", "#  #", "####")).getBoard();

        unit.occupy(board.squareAt(1, 2));
        unit.occupy(board.squareAt(1, 2));
        assertThat(unit.getSquare()).isEqualTo(board.squareAt(1, 2));
    }
}
