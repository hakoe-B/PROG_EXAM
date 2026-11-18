/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    // Test data from the sample screenshot
    private int[][] getTestData() {
        return new int[][]{
            {25, 18, 20}, // Cozy = 63
            {15, 10, 12}, // Restonic = 37
            {18, 15, 20}  // Sealy = 53
        };
    }

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(getTestData());
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(getTestData());
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }
}
