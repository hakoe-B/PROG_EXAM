/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package productapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductCalculationsTest {

    //Test1
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // Arrange - price 3500, VAT should be 525.0
        ProductCalculations calc = new ProductCalculations(3500);

        // Act
        double result = calc.GetVat();

        // Assert
        assertEquals(525.0, result, 0.01);
    }

     //Test2
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }

     @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        assertEquals(175.0, calc.GetCommission(), 0.01);
    }

    


}

/**
 *
 * @author Student
 */

