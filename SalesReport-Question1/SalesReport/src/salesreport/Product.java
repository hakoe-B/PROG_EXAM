/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesreport;

/**
 *
 * @author Student
 */
public class Product implements IProducts {
    // Single array - product names
    private String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    // Two-dimensional array - [product][month]
    private int[][] sales;

    public Product(int[][] sales) {
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        // Must be double or you get 17 instead of 17.0
        return (double) GetTotalProductsSold() / 9;
    }

    @Override
    public String GetMostPopularProduct() {
        // Highest single sale to match sample: Cozy Nights Monarch (25)
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > max) {
                    max = sales[i][j];
                    maxIndex = i;
                }
            }
        }
        return products[maxIndex] + " (" + max + ")";
    }
}
