import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter {
	int newNumColor=0,pastNumColor=0;
	int counter=0, counter2=0;
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
						
						if ((gridX == 0) || (gridY == 0) || (gridX == 10) || (gridY == 10)){
							//Do nothing
						}
						else {
							
							for(int i=1;i<=9;i++){
								for(int j=1;j<=9;j++){
									
									if(myPanel.colorArray[i][j] == Color.RED && myPanel.mineArray[i][j]==-1){
										
										counter2++;
									}
									
									
									}
								}
							if(counter2==9)
							{
								for(int i=1;i<=9;i++){
									for(int j=1;j<=9;j++){
										if(myPanel.mineArray[i][j]==-1){
											myPanel.colorArray[i][j] = Color.BLACK;
										}
										else{
											myPanel.colorArray[i][j] = Color.GRAY;
										}
									}
								}
								myPanel.repaint();
								JOptionPane.showMessageDialog(null, "WIN GAME");
								
							}
							
							if(myPanel.mineArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY]==-1){
								//Si el primero en tocar es una mina
								for(int i=1;i<=9;i++){
									for(int j=1;j<=9;j++){
										if(myPanel.mineArray[i][j]==-1){
											myPanel.colorArray[i][j] = Color.BLACK;
										}
										else{
											myPanel.colorArray[i][j] = Color.GRAY;
										}
									}
								}
								myPanel.repaint();
								JOptionPane.showMessageDialog(null, "LOSE GAME");
			
							}
							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY]==Color.WHITE){
									for(int h=myPanel.mouseDownGridY-1;h<=myPanel.mouseDownGridY+1;h++)
									{
										for(int k=myPanel.mouseDownGridX-1;k<=myPanel.mouseDownGridX+1;k++)
										{
											if(myPanel.mineArray[k][h]==0 && !(myPanel.colorArray[k][h]==Color.RED))
											{
												myPanel.colorArray[k][h] = Color.GRAY;
											}
											if(myPanel.minasAlrededor[k][h]==0)
											{
												for(int j=h-1;j<=h+1;j++)
													{
														for(int i=k-1;i<=k+1;i++)
														{
															if(myPanel.mineArray[i][j]==0 && !(myPanel.colorArray[i][j]==Color.RED)){
																myPanel.colorArray[i][j] = Color.GRAY;
															}
															
														}
													}	
											}
										}
								
								
									}
						
								}
							for(int i=1;i<=9;i++){
								for(int j=1;j<=9;j++){
									if(myPanel.colorArray[i][j] == Color.WHITE)
									{
										counter++;
										
									}
									if(myPanel.colorArray[i][j] == Color.RED && myPanel.mineArray[i][j]==-1){
										
										counter2++;
									}
									
									
									}
								}
							if(counter==9 || counter2==9)
							{
								for(int i=1;i<=9;i++){
									for(int j=1;j<=9;j++){
										if(myPanel.mineArray[i][j]==-1){
											myPanel.colorArray[i][j] = Color.BLACK;
										}
										else{
											myPanel.colorArray[i][j] = Color.GRAY;
										}
									}
								}
								myPanel.repaint();
								JOptionPane.showMessageDialog(null, "WIN GAME");
								
							}
							else{
								counter=0;
							}
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
			
			
			if ((gridX1 == 0) || (gridY1 == 0) || (gridX1 == 10) || (gridY1 == 10)){
				//Do nothing
			}
			else {
				if(myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] == Color.WHITE){
					myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = Color.RED;

					
				}
				else if(myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] == Color.RED){
					myPanel1.colorArray[myPanel1.mouseDownGridX][myPanel1.mouseDownGridY] = Color.WHITE;
				}
			}
			myPanel1.repaint();
			
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}