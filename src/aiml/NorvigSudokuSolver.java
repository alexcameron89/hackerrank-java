package aiml;

/**
 * Created by 220333 on 11/27/2015.
 */
public class NorvigSudokuSolver {
    String[] digits   = {"1","2","3","4","5","6","7","8","9"};
    String[] rows     = {"A","B","C","D","E","F","G","H","I"};
    String[] cols     = digits;
    String[] squares  = cross(rows, cols);

    private String[] cross(String[] rows, String[] cols) {
        String[] product = new String[rows.length * cols.length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                product[i*9 + j] = rows[i] + cols[j];
            }
        }

        return product;
    }


}
