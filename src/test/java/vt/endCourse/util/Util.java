package vt.endCourse.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Util {

	public void coppyPaste(String textCoppy) throws InterruptedException {
		Robot robot;
		try {
			robot = new Robot();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(textCoppy);

			clipboard.setContents(stringSelection, null);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void setKey(int key) {
		// button Ky so
		try {

			Robot robot;
			robot = new Robot();
			robot.setAutoDelay(50);
			robot.keyPress(key);
			robot.keyRelease(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Thực hiện lệnh js
	 */
	public static void executeJS(WebDriver driver, String javascript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javascript);
	}

}
