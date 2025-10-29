package org.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BackScoringTest {
    @Test
    void on_Even_shouldReturnLoveLove(){
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(0,0);

        //Assert
        assertEquals("Love-Love", result);

    }
    @Test
    void on_EvenForty_shouldReturnDeuce(){
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act
        String result = tennisGameScoring.transformScoreToText(40,40);

        //Assert
        assertEquals("Deuce", result);

    }

    @Test
    void on_Advantage_ShouldReturnAdvantage(){
        //Arrange
        TennisGameScoring tennisGameScoring = new TennisGameScoring();

        //Act



    }
}
