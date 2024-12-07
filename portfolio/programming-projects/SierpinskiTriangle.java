//Jacob Chisholm
import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        SierpinskiTriangle panel = new SierpinskiTriangle();

        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] xPoints = {400, 50, 750};// vertices of the triangle
        int[] yPoints = {50, 700, 700};
        
        drawTriangle(g, xPoints, yPoints, 4); // recursion with a depth 4
    }

    private void drawTriangle(Graphics g, int[] x, int[] y, int depth) {
        
            if (depth == 0) {
                g.setColor(Color.BLACK);
                g.fillPolygon(x, y, 3); // Draw filled triangle
                return;
            }
    
            // Calculate midpoints
            int midX1 = (x[0] + x[1]) / 2;
            int midY1 = (y[0] + y[1]) / 2;
            int midX2 = (x[1] + x[2]) / 2;
            int midY2 = (y[1] + y[2]) / 2;
            int midX3 = (x[0] + x[2]) / 2;
            int midY3 = (y[0] + y[2]) / 2;
    
            // Draw triangles
            int[] topX = {x[0], midX1, midX3};
            int[] topY = {y[0], midY1, midY3};
            drawTriangle(g, topX, topY, depth - 1);

            int[] leftX = {midX1, x[1], midX2};
            int[] leftY = {midY1, y[1], midY2};
            drawTriangle(g, leftX, leftY, depth - 1);
    
            int[] rightX = {midX3, midX2, x[2]};
            int[] rightY = {midY3, midY2, y[2]};
            drawTriangle(g, rightX, rightY, depth - 1);
    }
}
