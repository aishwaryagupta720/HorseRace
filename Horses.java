import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Horses extends JFrame implements Runnable {
	int x1, x2, x3, x4;

	public Horses() {
		x1 = x2 = x3 = x4 = 10;
		initFrame();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image k=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Smita\\Documents\\WorkspaceJ Aish\\MyProject\\src\\field.png");
		g.drawImage(k, 0, 0, 900, 900, this);
		g.setColor(Color.RED);
		g.drawLine(50, 0, 50, 800);
		Font f=new Font("Ariel Black", Font.BOLD, 20);
		g.setFont(f);
		g.drawString("START", 50, 50);
		g.setColor(Color.BLUE);
		g.drawLine(800, 0, 800, 800);
		g.drawString("FINISH", 800, 50);
		Image j=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Smita\\Documents\\WorkspaceJ Aish\\MyProject\\src\\trough.png");
		g.drawImage(j, 600, 110, 40, 50, this);
		g.drawImage(j, 600, 310, 40, 50, this);
		g.drawImage(j, 600, 510, 40, 50, this);
		g.drawImage(j, 600, 710, 40, 50, this);
		Image i = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Smita\\Documents\\WorkspaceJ Aish\\MyProject\\src\\horse.png");
		g.drawImage(i, x1, 100, 85, 60, this);
		g.drawImage(i, x2, 300, 85, 60, this);
		g.drawImage(i, x3, 500, 85, 60, this);
		g.drawImage(i, x4, 700, 85, 60, this);
	}

	public void initFrame() {
		this.setTitle("Horse Race");
		this.setSize(900, 900);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void horse1() throws InterruptedException {
		while(x1!=800) {
			x1++;
			Thread.sleep(50);
			repaint();
			synchronized (this) {
				if(x1==500) {
					this.wait();
				}
			}
		}


	}

	private void horse2() throws InterruptedException {
		while(x2!=800) {
			x2++;
			Thread.sleep(30);
			repaint();
			synchronized (this) {
				if(x2==500) {
					this.wait();
				}
			}
		}

	}

	private void horse3() throws InterruptedException {
		while(x3!=800) {
			x3++;
			Thread.sleep(70);
			repaint();

		synchronized (this) {
			if(x3==500) {
				this.wait();
			}
		}
		}
	}

	private void horse4() throws InterruptedException {
		while(x4!=800) {
			x4++;
			Thread.sleep(100);
			repaint();
			synchronized (this) {
				if(x4==500) {
					Thread.sleep(75);
					this.notifyAll();
				}

			}
		}

	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("horse1")) {
			try {
				horse1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Thread.currentThread().getName().equals("horse2")) {
			try {
				horse2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Thread.currentThread().getName().equals("horse3")) {
			try {
				horse3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Thread.currentThread().getName().equals("horse4")) {
			try {
				horse4();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Horses h=new Horses();
		Thread t1=new Thread(h,"horse1");
		Thread t2=new Thread(h,"horse2");
		Thread t3=new Thread(h,"horse3");
		Thread t4=new Thread(h,"horse4");


		t1.start();
		t2.start();
		t3.start();
		t4.start();


	}

}
