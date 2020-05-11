import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypeBot
{
	private JFrame window = new JFrame("TypeBot");

	public static void main(String[] args)
	{
		TypeBot TB = new TypeBot();
	}

	public TypeBot()
	{
		window.setVisible(true);
		JTextField text = new JTextField(20);
		KeyListener listener = new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent event){}
			@Override
			public void keyReleased(KeyEvent event){}
			@Override
			public void keyTyped(KeyEvent event){}
		};
		text.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				writeString(text.getText());
			}
		}
		);
		text.addKeyListener(listener);
		JPanel panel = new JPanel();
		panel.add(text);
		window.add(panel);
		window.setSize(300, 100);
	}

	private void writeString(String s)
	{
		Robot robot;
		try
		{
			robot = new Robot();
			robot.delay(1000);
			for (int i = 0; i < s.length(); i++)
			{
				robot.delay(50);
				char c = s.charAt(i);
				switch(c)
				{
					case ':':
						robot.keyPress(KeyEvent.VK_SHIFT);
						robot.keyPress(KeyEvent.VK_SEMICOLON);
						robot.keyRelease(KeyEvent.VK_SEMICOLON);
						robot.keyRelease(KeyEvent.VK_SHIFT);
						break;

					case '.':
						robot.keyPress(KeyEvent.VK_PERIOD);
						robot.keyRelease(KeyEvent.VK_PERIOD);
						break;

					default:
						if (Character.isUpperCase(c))
						{
							robot.keyPress(KeyEvent.VK_SHIFT);
						}
						robot.keyPress(Character.toUpperCase(c));
						robot.keyRelease(Character.toUpperCase(c));
						if (Character.isUpperCase(c))
						{
							robot.keyRelease(KeyEvent.VK_SHIFT);
						}
						break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.print(false);
		}
	}
}

