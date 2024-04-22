package customEntities;

import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;
import java.util.Vector;

import javax.swing.border.AbstractBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import com.jidesoft.swing.AutoCompletionComboBox;

import java.awt.*;


import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class Custom_ComboBox extends JComboBox<Object> implements PopupMenuListener {
	private Color color_Foreground;
	private Color color_Background;
	private Color color_Hightlight;
	private Color color_Over;
	private Color color_Border;
	private int radius;
	private boolean arrowButton_IsVisible;
	private Custom_Button custom_Button;
	public Custom_Button getCustom_Button() {
		return custom_Button;
	}

	public void setCustom_Button(Custom_Button custom_Button) {
		this.custom_Button = custom_Button;
	}

	//private String keyWord[];
	//String keyWord[] = {"Nguyen Hoang Huy","Lương Quốc Thái","Le Thanh An"};
	private Vector<String> myVector = new Vector();

	/**
	 * @return the color_Foreground
	 */
	public Color getColor_Foreground() {
		return color_Foreground;
	}

	/**
	 * @return the color_Background
	 */
	public Color getColor_Background() {
		return color_Background;
	}

	public Vector<String> getMyVector() {
		return myVector;
	}

	public void setMyVector(Vector<String> myVector) {
		this.myVector = myVector;
	}

	/**
	 * @return the color_Hightlight
	 */
	public Color getColor_Hightlight() {
		return color_Hightlight;
	}

	/**
	 * @return the color_Over
	 */
	public Color getColor_Over() {
		return color_Over;
	}

	/**
	 * @return the color_Border
	 */
	public Color getColor_Border() {
		return color_Border;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @return the arrowButton_IsVisible
	 */
	public boolean isArrowButton_IsVisible() {
		return arrowButton_IsVisible;
	}

	/**
	 * @param color_Foreground the color_Foreground to set
	 */
	public void setColor_Foreground(Color color_Foreground) {
		this.color_Foreground = color_Foreground;
	}

	/**
	 * @param color_Background the color_Background to set
	 */
	public void setColor_Background(Color color_Background) {
		this.color_Background = color_Background;
	}

	/**
	 * @param color_Hightlight the color_Hightlight to set
	 */
	public void setColor_Hightlight(Color color_Hightlight) {
		this.color_Hightlight = color_Hightlight;
	}

	/**
	 * @param color_Over the color_Over to set
	 */
	public void setColor_Over(Color color_Over) {
		this.color_Over = color_Over;
	}

	/**
	 * @param color_Border the color_Border to set
	 */
	public void setColor_Border(Color color_Border) {
		this.color_Border = color_Border;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @param arrowButton_IsVisible the arrowButton_IsVisible to set
	 */
	public void setArrowButton_IsVisible(boolean arrowButton_IsVisible) {
		this.arrowButton_IsVisible = arrowButton_IsVisible;
	}
	
	public Custom_ComboBox(Object[] objects,Color color_Foreground, Color color_Background, Color color_Hightlight, Color color_Over,
			Color color_Border, int radius, boolean arrowButton_IsVisible) {
		super(objects);
		this.color_Foreground = color_Foreground;
		this.color_Background = color_Background;
		this.color_Hightlight = color_Hightlight;
		this.color_Over = color_Over;
		this.color_Border = color_Border;
		this.radius = radius;
		this.arrowButton_IsVisible = arrowButton_IsVisible;
		redraw_Custom_Combobox();
		setEditable(true);
	}

	public Custom_ComboBox() {
		//String[] model = {"Lựa chọn 1","Lựa chọn 2"};
		this(new String[] {},Color.BLACK,Color.white,Color.BLACK,Color.white,Color.BLUE,0,true);
		redraw_Custom_Combobox();
	}

	public Custom_ComboBox(Object[] objects) {
		this(objects,Color.BLACK,Color.white,Color.BLACK,Color.white,Color.BLUE,0,true);
	}

	public void redraw_Custom_Combobox() {
		UIManager.put("ComboBox.foreground", color_Foreground);
	    UIManager.put("ComboBox.background", color_Background);
	    UIManager.put("ComboBox.selectionForeground", color_Hightlight);
	    UIManager.put("ComboBox.selectionBackground", color_Over);

	    UIManager.put("ComboBox.buttonDarkShadow", color_Foreground);
	    UIManager.put("ComboBox.buttonBackground", color_Background);
	    UIManager.put("ComboBox.buttonHighlight",  color_Hightlight);
	    UIManager.put("ComboBox.buttonShadow",     color_Over);
	    
	    if(radius!=0) {
	    	UIManager.put("ComboBox.border", new RoundedCornerBorder());
	    }
	    else {
	    	setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, color_Border, Custom_ColorPicker.snowwhite_F2F0EB));
	    }
	    
	    
		 //* setBorder(new RoundedCornerBorder());
	    if(arrowButton_IsVisible) {
	    	setUI(new BasicComboBoxUI() {
	    	@Override
	    	protected JButton createArrowButton() {
	    		JButton button = new BasicArrowButton(BasicArrowButton.SOUTH,
                UIManager.getColor("ComboBox.buttonBackground"),
                UIManager.getColor("ComboBox.buttonShadow"),
                UIManager.getColor("ComboBox.buttonDarkShadow"),
                UIManager.getColor("ComboBox.buttonHighlight"));
				button.setName("ComboBox.arrowButton");
				return button;}
	    	
	    	public void layoutContainer(Container parent) {
	            @SuppressWarnings("unchecked")
	            JComboBox<?> cb = (JComboBox)parent;
	            int width = cb.getWidth();
	            int height = cb.getHeight();

	            Insets insets = getInsets();
	            int buttonHeight = height - (insets.top + insets.bottom);
	            int buttonWidth = buttonHeight;
	            if (arrowButton != null) {
	                Insets arrowInsets = arrowButton.getInsets();
	                buttonWidth = squareButton ?
	                    buttonHeight :
	                    (int)(arrowButton.getPreferredSize().width*0.6) + arrowInsets.left + arrowInsets.right;
	            }
	            Rectangle cvb;

	            if (arrowButton != null) {
	                if (true) {
	                    arrowButton.setBounds(width - (insets.right + buttonWidth),
	                            insets.top, buttonWidth, buttonHeight);
	                } else {
	                    arrowButton.setBounds(insets.left, insets.top,
	                            buttonWidth, buttonHeight);
	                }
	            }
	            if ( editor != null ) {
	                cvb = rectangleForCurrentValue();
	                editor.setBounds(cvb);
	            }}}
	    	);
	    }
	    //else setUI(new BasicComboBoxUI());
	    setSelectedIndex(-1);
	    JTextField text = (JTextField) this.getEditor().getEditorComponent();
	    text.setFocusable(true);
	    text.setText("");
	    text.addKeyListener(new ComboListener(this, myVector));
	    myVector.clear();
	    setMyVector(myVector);
	    Object o = this.getAccessibleContext().getAccessibleChild(0);
	    if (o instanceof JComponent) {
	      JComponent c = (JComponent) o;
	      c.setBorder(BorderFactory.createLineBorder(color_Border));
	      c.setForeground(color_Foreground);
	      c.setBackground(color_Background);
	    }
	    addPopupMenuListener(this);
	}
	/**
	 * set the item list of the AutoComboBox
	 * @param keyWord an String array
	 */

	
	@Override
	public void popupMenuWillBecomeVisible(final PopupMenuEvent e) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JComboBox combo = (JComboBox) e.getSource();
				Accessible a = combo.getUI().getAccessibleChild(combo, 0);
				if (a instanceof BasicComboPopup) {
					BasicComboPopup pop = (BasicComboPopup) a;
					Container top = pop.getTopLevelAncestor();
					if (top instanceof JWindow) {
						// http://ateraimemo.com/Swing/DropShadowPopup.html
						System.out.println("HeavyWeightContainer");
						((JWindow) top).setBackground(new Color(0x0, true));
					}
				}
			}
		});
	}

	public JPanel getPanel(Color panelColor, int x, int y, int height, int width) {
		JPanel pnCustomComboxBox = new JPanel();
		pnCustomComboxBox.add(this);
		pnCustomComboxBox.setBackground(panelColor);

		this.setPreferredSize(new Dimension((int) (height * 0.9), (int) (width * 0.9)));
		pnCustomComboxBox.setBounds(x, y, height, width);
		pnCustomComboxBox.setPreferredSize(new Dimension(height, width));
		return pnCustomComboxBox;
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		UIManager.put("ComboBox.selectionForeground", color_Foreground);
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {
		// TODO Auto-generated method stub

	}
	
}