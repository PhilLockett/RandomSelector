/*
 * This RandomSelector class is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This RandomSelector class is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this java class.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.phillockett65;

import java.util.Random;

/**
 *
 * @author Phil
 */
public class RandomSelector {

    private final int[] selection;
    private final int[] items;
    private int available;
    private Random rand;

    /**
     * Construct a Selector with the range 1..size.
     *
     * @param size value range from 1..size.
     */
    public RandomSelector(int size) {
        rand = new Random();
        selection = new int[size];
        items = new int[size];

        // Seed items[] with 1, 2, 3,...size.
        for (int i = 0; i < items.length; i++) {
            items[i] = i + 1;
        }
        reset();
    }

    /**
     * Construct a Selector with the values in the digits array.
     *
     * @param digits array containing the values to select from.
     */
    public RandomSelector(int[] digits) {
        rand = new Random();
        selection = new int[digits.length];
        items = new int[digits.length];

        // Seed items.
        for (int i = 0; i < items.length; i++) {
            items[i] = digits[i];
        }
        reset();
    }

    /**
     * Set the Selector to it's initial state.
     */
    public void reset() {
        available = selection.length;

        // Seed selection (1, 2, 3,...).
        for (int i = 0; i < selection.length; i++) {
            selection[i] = items[i];
        }
    }

    /**
     * Get the count of values initially available.
     *
     * @return the number of values initially available.
     */
    public int getCount() {
        return selection.length;
    }

    /**
     * Get the count of values currently available.
     *
     * @return the number of values still available.
     */
    public int getAvailable() {
        return available;
    }

    /**
     * Remove the given value from the selection.
     *
     * @param value to remove.
     * @return true if the value was still available and has been removed, false
     * otherwise.
     */
    public boolean remove(int value) {
        if (available < 1) {
            return false;
        }

        for (int i = 0; i < available; i++) {
            if (selection[i] == value) {
                available--;
                selection[i] = selection[available];

                return true;
            }
        }

        return false;
    }

    /**
     * Randomly get a value from the selection and make it no longer available.
     *
     * @return the randomly selected value.
     */
    public int get() {
        if (available < 1) {
            return 0;
        }

        if (available == 1) {
            available--;
            return selection[0];
        }

        // Generate a random integer in range 0 to available-1.
        final int index = rand.nextInt(available);
        final int result = selection[index];
        available--;
        selection[index] = selection[available];

        return result;
    }

    /**
     * Creates a String listing all remaining available values.
     *
     * @return the String of values.
     */
    @Override
    public String toString() {
        String string = "";

        if (available < 1) {
            return string;
        }

        string += String.valueOf(selection[0]);
        for (int i = 1; i < available; i++) {
            string += ", " + String.valueOf(selection[i]);
        }

        return string;
    }

    /**
     * Test the RandomSelector class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final RandomSelector sel = new RandomSelector(9);

        System.out.println("Initial state of sel (continuous sequence):");
        System.out.printf("  sel.getCount() = %d    sel.getAvailable() = %d  sel = %s\n", sel.getCount(), sel.getAvailable(), sel.toString());
        System.out.println();
        System.out.println("Now randomly get all values, and then 1 more:");
        for (int i = 0; i < sel.getCount() + 1; i++) {
            System.out.printf("  i = %d - sel.getAvailable() = %d  sel.get() = %d  sel = %s\n", i, sel.getAvailable(), sel.get(), sel.toString());
        }

        System.out.println();
        sel.reset();
        System.out.println("State of sel after reset:");
        System.out.printf("  sel.getCount() = %d    sel.getAvailable() = %d  sel = %s\n", sel.getCount(), sel.getAvailable(), sel.toString());
        System.out.println();
        System.out.println("Now randomly get 5 values:");
        for (int i = 0; i < 5; i++) {
            System.out.printf("  i = %d - sel.getAvailable() = %d  sel.get() = %d  sel = %s\n", i, sel.getAvailable(), sel.get(), sel.toString());
        }

        System.out.println();
        System.out.println("Now try to remove the first 5 values and check validity:");
        for (int i = 1; i < 6; i++) {
            System.out.printf("  i = %d - sel.getAvailable() = %d  sel.remove(%d) = %s  sel = %s\n", i, sel.getAvailable(), i, sel.remove(i) ? "removed" : "gone", sel.toString());
        }

        int[] fibonacci = {1, 1, 2, 3, 5, 8, 13, 21};
        final RandomSelector sel2 = new RandomSelector(fibonacci);

        System.out.println();
        System.out.println("Initial state of sel2 (customised sequence):");
        System.out.printf("  sel2.getCount() = %d    sel2.getAvailable() = %d  sel2 = %s\n", sel2.getCount(), sel2.getAvailable(), sel2.toString());
        System.out.println();
        System.out.println("Now randomly get all values:");
        for (int i = 0; i < sel2.getCount(); i++) {
            System.out.printf("  i = %d - sel2.getAvailable() = %d  sel2.get() = %d  sel2 = %s\n", i, sel2.getAvailable(), sel2.get(), sel2.toString());
        }
    }

}
