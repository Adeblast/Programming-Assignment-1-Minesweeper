import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	public Random generator = new Random();
	int newNumColor=0,pastNumColor=0;
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			Component c1 = e.getComponent();
			while (!(c1 instanceof JFrame)) {
				c1 = c1.getParent();
				if (c1 == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame) c1;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
			Insets myInsets1 = myFrame1.getInsets();
			int x1_2 = myInsets1.left;
			int y1_2 = myInsets1.top;
			e.translatePoint(-x1_2, -y1_2);
			int x2 = e.getX();
			int y2 = e.getY();
			myPanel1.x = x2;
			myPanel1.y = y2;
			myPanel1.mouseDownGridX = myPanel1.getGridX(x2, y2);
			myPanel1.mouseDownGridY = myPanel1.getGridY(x2, y2);
			myPanel1.repaint();
			break;
			
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
//						if ((gridX == 0) && (gridY == 10)) {
//							
//							Color newColor = null;
//				
//							while(newNumColor==pastNumColor){
//								newNumColor=generator.nextInt(5);
//							}
//									
//							switch (newNumColor) {
//							case 0:
//								newColor = Color.YELLOW;
//								break;
//							case 1:
//								newColor = Color.MAGENTA;
//								break;
//							case 2:
//								newColor = Color.BLACK;
//								break;
//							case 3:
//								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							case 4:
//								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							}
//							pastNumColor=newNumColor;
//							for(int i=4;i<7;i++)
//								{
//								for(int j=4;j<7;j++){
//									myPanel.colorArray[i][j] = newColor;
//								}
//							}	
//							myPanel.repaint();
//							}
//						if ((gridX == 0) && (gridY == 0)) {
//							
//							Color newColor = null;
//				
//							while(newNumColor==pastNumColor){
//								newNumColor=generator.nextInt(5);
//							}
//									
//							switch (newNumColor) {
//							case 0:
//								newColor = Color.YELLOW;
//								break;
//							case 1:
//								newColor = Color.MAGENTA;
//								break;
//							case 2:
//								newColor = Color.BLACK;
//								break;
//							case 3:
//								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							case 4:
//								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							}
//							pastNumColor=newNumColor;
//							for(int i=1;i<10;i++)
//							{
//								myPanel.colorArray[i][i] = newColor;
//							}
//							myPanel.repaint();
//							}
//							if (!(gridX == 0) && (gridY == 0)) {
//							
//							Color newColor = null;
//				
//							while(newNumColor==pastNumColor){
//								newNumColor=generator.nextInt(5);
//							}
//									
//							switch (newNumColor) {
//							case 0:
//								newColor = Color.YELLOW;
//								break;
//							case 1:
//								newColor = Color.MAGENTA;
//								break;
//							case 2:
//								newColor = Color.BLACK;
//								break;
//							case 3:
//								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							case 4:
//								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							}
//							pastNumColor=newNumColor;
//							for(int i=1;i<10;i++)
//							{
//								myPanel.colorArray[myPanel.mouseDownGridX][i] = newColor;
//							}
//							myPanel.repaint();
//							}
//						if ((gridX == 0) && !(gridY == 0)) {
//							
//							Color newColor = null;
//				
//							while(newNumColor==pastNumColor){
//								newNumColor=generator.nextInt(5);
//							}
//									
//							switch (newNumColor) {
//							case 0:
//								newColor = Color.YELLOW;
//								break;
//							case 1:
//								newColor = Color.MAGENTA;
//								break;
//							case 2:
//								newColor = Color.BLACK;
//								break;
//							case 3:
//								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							case 4:
//								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
//								break;
//							}
//							pastNumColor=newNumColor;
//							for(int i=1;i<10;i++)
//							{
//								myPanel.colorArray[i][myPanel.mouseDownGridY] = newColor;
//							}
//							myPanel.repaint();
//							}
						if ((gridX == 0) || (gridY == 0) || (gridX == 10) || (gridY == 10)){
							//Do nothing
						}
						else {
							//On the grid other than on the left column and on the top row:
							Color newColor = null;
							
							while(newNumColor==pastNumColor){
								newNumColor=generator.nextInt(5);
							}
								
								
								
							switch (newNumColor) {
							case 0:
								newColor = Color.YELLOW;
								break;
							case 1:
								newColor = Color.MAGENTA;
								break;
							case 2:
								newColor = Color.BLACK;
								break;
							case 3:
								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							case 4:
								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
							pastNumColor=newNumColor;
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:
			Component c1 = e.getComponent();
			while (!(c1 instanceof JFrame)) {
				c1 = c1.getParent();
				if (c1 == null) {
					return;
				}
			}
			JFrame myFrame1 = (JFrame) c1;
			MyPanel myPanel1 = (MyPanel) myFrame1.getContentPane().getComponent(0);
			Insets myInsets1 = myFrame1.getInsets();
			int x1_2 = myInsets1.left;
			int y1_2 = myInsets1.top;
			e.translatePoint(-x1_2, -y1_2);
			int x2 = e.getX();
			int y2 = e.getY();
			myPanel1.x = x2;
			myPanel1.y = y2;
			myPanel1.mouseDownGridX = myPanel1.getGridX(x2, y2);
			myPanel1.mouseDownGridY = myPanel1.getGridY(x2, y2);
			int gridX1 = myPanel1.getGridX(x2, y2);
			int gridY1 = myPanel1.getGridY(x2, y2);
			
			
			if((gridX1 == 0) || (gridY1 == 0)){
				
				Color newColor = null;
				
				while(newNumColor==pastNumColor){
					newNumColor=generator.nextInt(3);
				}
					
							
				switch (newNumColor) {
				case 0:
					newColor = Color.RED;
					break;
				case 1:
					newColor = Color.BLUE;
					break;
				case 2:
					newColor = Color.CYAN;
					break;
				}
				for(int i=1;i<10;i++){
					for(int j=1;j<10;j++){
						myPanel1.colorArray[i][j] = newColor;
					}
				}
			}
			myPanel1.repaint();
			pastNumColor=newNumColor;
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}