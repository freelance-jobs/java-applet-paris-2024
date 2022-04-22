import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
<applet code="ITE409_LAB6.class" width=1000 height=800>
</applet>
*/

public class ITE409_LAB6 extends Applet implements ActionListener {
	private static final int CIRCLE_DIAMETER = 200;
    private static final int CIRCLE_GAP = (CIRCLE_DIAMETER/8);
    private static final Color[] LINE1_COLORS = {Color.BLUE, Color.BLACK, Color.RED};
    private static final Color[] LINE2_COLORS = {Color.YELLOW, Color.GREEN};

    private static final int LINE1_ROW = CIRCLE_DIAMETER / 2;
    private static final int LINE1_COL_START = CIRCLE_DIAMETER / 2;
    private static final int LINE2_ROW = LINE1_ROW + CIRCLE_DIAMETER / 2;
    private static final int LINE2_COL_START = LINE1_COL_START + (CIRCLE_DIAMETER + CIRCLE_GAP) / 2;
    private static final int LINE3_ROW = LINE2_ROW + 2 * CIRCLE_DIAMETER;
    private static final int LINE3_COL = 250;
	int count = 0;

	public void init() {
		setLayout(new BorderLayout());// setting layout
		Button b = new Button("Go");// creating button
		add("South", b); // adding button to applet
		b.addActionListener(this); // adding actionListener to button b
	}

	public void paint(Graphics g)// repaint () calls paint () method internally
	{
		if (count >= 1){
            for(int i = 0; i < Math.min(count, 3); i++){
                drawCircle(g, LINE1_COL_START + (i*(CIRCLE_DIAMETER+CIRCLE_GAP)), LINE1_ROW, CIRCLE_DIAMETER, LINE1_COLORS[i]);
            }
        }
		if (count >= 4){
            for(int i = 0; i < Math.min(count-3, 2); i++){
                drawCircle(g, LINE2_COL_START + (i*(CIRCLE_DIAMETER+CIRCLE_GAP)), LINE2_ROW, CIRCLE_DIAMETER, LINE2_COLORS[i]);
            }
        }
        if (count >= 6){
            drawCenteredString(g, "PARIS 2024", LINE3_COL, LINE3_ROW);
        }

	}

    public void drawCenteredString(Graphics g, String s, int left, int top) {
        Font font = new Font("Arial", Font.BOLD, CIRCLE_DIAMETER / 4);
        g.setFont(font);
        g.setColor(Color.gray); 
        g.drawString(s, left, top);
    }

	private void drawCircle(Graphics g, int centerX, int centerY, int radius, Color color){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(CIRCLE_DIAMETER/10));
		g.setColor(color);
		g.drawOval(centerX, centerY, radius, radius);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		count++;
	}
}