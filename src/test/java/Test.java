import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class Test {

    protected static ShapeClassifier shapeClassifier;

    @BeforeAll
    public static void setUp() {
        // Initialize the ShapeClassifier object once for all tests
        shapeClassifier = Mockito.spy(new ShapeClassifier());
    }

    @Test
    public void testEvaluateGuess_ValidEquilateralTriangle() {
        // Arrange
        shapeClassifier = new ShapeClassifier();
        String input = "Equilateral,Large,Yes,10,10,10";

        // Act
        String result = shapeClassifier.evaluateGuess(input);

        // Assert
        assertEquals("Yes", result, "Valid equilateral triangle should return 'Yes'");
    }

    @Test
    public void testEvaluateGuess_InvalidShapeGuess() {
        // Arrange
        String input = "Scalene,Large,Yes,10,10,10";

        // Act
        String result = shapeClassifier.evaluateGuess(input);

        // Assert
        assertEquals("No: Suggestion=Equilateral", result, "Incorrect shape guess should suggest the correct shape");
    }

    @Test
    public void testEvaluateGuess_InvalidSizeGuess() {
        // Arrange
        String input = "Equilateral,Small,Yes,50,50,50";

        // Act
        String result = shapeClassifier.evaluateGuess(input);

        // Assert
        assertEquals("Wrong Size", result, "Incorrect size guess should return 'Wrong Size'");
    }

    @Test
    public void testEvaluateGuess_InvalidEvenOddGuess() {
        // Arrange
        String input = "Equilateral,Large,No,10,10,10";

        // Act
        String result = shapeClassifier.evaluateGuess(input);

        // Assert
        assertEquals("Wrong Even/Odd", result, "Incorrect even/odd guess should return 'Wrong Even/Odd'");
    }

    // @Test
    // public void testEvaluateGuess_TooManyBadGuesses() {
    //     // Arrange
    //     doNothing().when(shapeClassifier).makeSuggestion(any(), anyString(), anyString());
        
    //     String badInput1 = "Line,Small,Yes,50"; // Incorrect guess
    //     String badInput2 = "Line,Small,Yes,100"; // Incorrect guess
    //     String badInput3 = "Line,Small,Yes,150"; // Incorrect guess

    //     // Act
    //     shapeClassifier.evaluateGuess(badInput1);
    //     shapeClassifier.evaluateGuess(badInput2);
        
    //     // This call should terminate the program, so we handle it.
    //     Exception exception = assertThrows(Exception.class, () -> shapeClassifier.evaluateGuess(badInput3));

    //     // Assert
    //     assertEquals("ERROR: Bad guess limit Exceeded", exception.getMessage());
    // }

    // @Test
    // public void testClassify4Parameters_Square() {
    //     // Arrange
    //     ShapeClassifier shapeClassifier = spy(new ShapeClassifier());
    //     int side1 = 10, side2 = 10, side3 = 10, side4 = 10;

    //     // Act
    //     String result = shapeClassifier.classify4Parameters(side1, side2, side3, side4);

    //     // Assert
    //     assertEquals("Square", result, "Four equal sides should classify as 'Square'");
    // }

    // @Test
    // public void testClassify3Parameters_Isosceles() {
    //     // Arrange
    //     ShapeClassifier shapeClassifier = spy(new ShapeClassifier());
    //     int a = 10, b = 10, c = 15;

    //     // Act
    //     String result = shapeClassifier.classify3Parameters(a, b, c);

    //     // Assert
    //     assertEquals("Isosceles", result, "Two equal sides should classify as 'Isosceles'");
    // }

    // @Test
    // public void testClassify2Parameters_Circle() {
    //     // Arrange
    //     ShapeClassifier shapeClassifier = spy(new ShapeClassifier());
    //     int radius1 = 10, radius2 = 10;

    //     // Act
    //     String result = shapeClassifier.classify2Parameters(radius1, radius2);

    //     // Assert
    //     assertEquals("Circle", result, "Two equal parameters should classify as 'Circle'");
    // }

    // @Test
    // public void testMakeSuggestion_Line() throws Exception {
    //     // Arrange
    //     ShapeClassifier shapeClassifier = spy(new ShapeClassifier());
    //     Integer[] params = {5};
    //     String shapeGuess = "Rectangle";
    //     String guessResult = "";

    //     // Act
    //     String suggestion = shapeClassifier.makeSuggestion(params, shapeGuess, guessResult);

    //     // Assert
    //     assertEquals("Suggestion=Line", suggestion, "Single parameter should suggest 'Line'");
    // }
}