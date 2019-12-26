import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
public class BlockBreaker extends JPanel implements KeyListener,ActionListener{
	JFrame f1=new JFrame();
	Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
	JLabel[] jLabelArr1;
	JLabel[] jLabelArr2;
	JLabel[] jLabelArr3;
	JLabel[] jLabelArr4;
	JLabel[] jLabelArr5;
	JLabel tray;
	int traycount=600;
	int arr1[]=new int[22];
	int arr2[]=new int[22];
	int arr3[]=new int[22];
	int arr4[]=new int[22];
	Timer t=new Timer(5,this);
	double x=150,y=150,velx=4, vely=4;
	Ellipse2D circle;
	BlockBreaker(){
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f1.setSize(d);
		f1.setTitle("Block Breaker Game");
		f1.getContentPane().setBackground(Color.black);
		setLayout(null);
		setBackground(Color.black);
		jLabelArr1 = new JLabel[22];
		jLabelArr2 = new JLabel[22];
		jLabelArr3 = new JLabel[22];
		jLabelArr4 = new JLabel[22];
		jLabelArr5 = new JLabel[22];
		tray=new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\tray.png"));
		int count=20;
        for(int i =0; i < 22; i++) {

            jLabelArr1[i] = new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\green.png"));
            jLabelArr1[i].setBounds(count, 0,60, 30);
            count+=60;
            add(jLabelArr1[i]);
        }
        count=20;
        for(int i =0; i < 22; i++) {

            jLabelArr2[i] = new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\pink.png"));
            jLabelArr2[i].setBounds(count, 30,60, 30);
            count+=60;
            add(jLabelArr2[i]);
        }
        count=20;
        for(int i =0; i < 22; i++) {

            jLabelArr3[i] = new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\yellow.png"));
            jLabelArr3[i].setBounds(count, 60,60, 30);
            count+=60;
            add(jLabelArr3[i]);
        }
        count=20;
        for(int i =0; i < 22; i++) {

            jLabelArr4[i] = new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\brown.png"));
            jLabelArr4[i].setBounds(count, 90,60, 30);
            count+=60;
            add(jLabelArr4[i]);
        }
        count=20;
        for(int i =0; i < 22; i++) {

            jLabelArr5[i] = new JLabel(new ImageIcon("C:\\Users\\Mayuri Gupta\\blue.png"));
            jLabelArr5[i].setBounds(count, 120,60, 30);
            count+=60;
            add(jLabelArr5[i]);
        }
        tray.setBounds(traycount, 600, 130, 40);
        add(tray);
        for(int i=0;i<22;i++)
        	arr1[i]=0;
        for(int i=0;i<22;i++)
        	arr2[i]=0;
        for(int i=0;i<22;i++)
        	arr3[i]=0;
        for(int i=0;i<22;i++)
        	arr4[i]=0;
        //MovingBall ball=new MovingBall();
        //ball.setBounds(0, 80, d.width, d.height);
        //ball.setBackground(Color.black);
        //add(ball);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
        f1.add(this);
		f1.setVisible(true);
	}
	public static void main(String args[]) {
		new BlockBreaker();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_RIGHT&&tray.getX()<(d.width-165)) {
			//System.out.println("hey");
			traycount+=60;
			tray.setBounds(traycount, 600, 130, 40);
			repaint();
			revalidate();
		}
		if(e.getKeyCode()== KeyEvent.VK_LEFT&&tray.getX()>0) {
			//System.out.println("hey");
			traycount-=60;
			tray.setBounds(traycount, 600, 130, 40);
			repaint();
			revalidate();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e1) {
		// TODO Auto-generated method stub
		//Graphics g;
		if(x<0||x>d.width)
			velx=-velx;
		if(y<0)
			vely=-vely;
		if(circle.getBounds().intersects(tray.getBounds())&&y<605)
			vely=-vely;
		for(int i =0; i < 22; i++) {
			if(circle.getBounds().intersects(jLabelArr1[i].getBounds())) {
				vely=-vely;
				remove(jLabelArr1[i]);
				repaint();
			}
		}
		for(int i =0; i < 22; i++) {
			if(arr1[i]<2&&circle.getBounds().intersects(jLabelArr2[i].getBounds())) {
				//System.out.println(i);
				vely=-vely;
				arr1[i]+=1;
				remove(jLabelArr2[i]);
				repaint();
			}
        
        }
		for(int i =0; i < 22; i++) {
			if(arr2[i]<2&&circle.getBounds().intersects(jLabelArr3[i].getBounds())) {
				//System.out.println(i);
				vely=-vely;
				arr2[i]+=1;
				remove(jLabelArr3[i]);
				repaint();
			}
        
        }
		for(int i =0; i < 22; i++) {
			if(arr3[i]<2&&circle.getBounds().intersects(jLabelArr4[i].getBounds())) {
				//System.out.println(i);
				vely=-vely;
				arr3[i]+=1;
				remove(jLabelArr4[i]);
				repaint();
			}
        
        }
		for(int i =0; i < 22; i++) {
			if(arr4[i]<2&&circle.getBounds().intersects(jLabelArr5[i].getBounds())) {
				//System.out.println(i);
				vely=-vely;
				arr4[i]+=1;
				remove(jLabelArr5[i]);
				repaint();
			}
        
        }
		//System.out.println(x+" "+y);
		x+=velx;
		y+=vely;
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		circle=new Ellipse2D.Double(x,y,40,40);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(circle);
		t.start();
	}
}
