package customEntities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;


import javax.swing.BorderFactory;

import javax.swing.JLabel;

import javax.swing.JTable;



import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


public class Custom_Table extends JTable{
	private Color color_Header_Background;
	private Color color_Header_Foreground;
	private Color color_Foreground;
	private Color color_StripeForeground;
	private Color color_StripeBackground;
	private Color color_Border;
	private int height_Cell;
	private final int left_Align = 0;
	private final int center_Align = 1;
	private final int right_Align = 2;
	/**
	 * @return the color_Header_Background
	 */
	public Color getColor_Header_Background() {
		return color_Header_Background;
	}

	/**
	 * @return the color_Header_Foreground
	 */
	public Color getColor_Header_Foreground() {
		return color_Header_Foreground;
	}

	/**
	 * @return the color_Foreground
	 */
	public Color getColor_Foreground() {
		return color_Foreground;
	}

	/**
	 * @return the color_StripeForeground
	 */
	public Color getColor_StripeForeground() {
		return color_StripeForeground;
	}

	/**
	 * @return the color_StripeBackground
	 */
	public Color getColor_StripeBackground() {
		return color_StripeBackground;
	}

	/**
	 * @return the color_Border
	 */
	public Color getColor_Border() {
		return color_Border;
	}

	/**
	 * @return the height_Cell
	 */
	public int getHeight_Cell() {
		return height_Cell;
	}

	/**
	 * @param color_Header_Background the color_Header_Background to set
	 */
	public void setColor_Header_Background(Color color_Header_Background) {
		this.color_Header_Background = color_Header_Background;
	}

	/**
	 * @param color_Header_Foreground the color_Header_Foreground to set
	 */
	public void setColor_Header_Foreground(Color color_Header_Foreground) {
		this.color_Header_Foreground = color_Header_Foreground;
	}

	/**
	 * @param color_Foreground the color_Foreground to set
	 */
	public void setColor_Foreground(Color color_Foreground) {
		this.color_Foreground = color_Foreground;
	}

	/**
	 * @param color_StripeForeground the color_StripeForeground to set
	 */
	public void setColor_StripeForeground(Color color_StripeForeground) {
		this.color_StripeForeground = color_StripeForeground;
	}

	/**
	 * @param color_StripeBackground the color_StripeBackground to set
	 */
	public void setColor_StripeBackground(Color color_StripeBackground) {
		this.color_StripeBackground = color_StripeBackground;
	}

	/**
	 * @param color_Border the color_Border to set
	 */
	public void setColor_Border(Color color_Border) {
		this.color_Border = color_Border;
	}

	/**
	 * @param height_Cell the height_Cell to set
	 */
	public void setHeight_Cell(int height_Cell) {
		this.height_Cell = height_Cell;
	}

	public void redrawn_Custom_Table() {
		JTableHeader header = this.getTableHeader();
	    header.setBackground(color_Header_Background);
	    header.setForeground(color_Header_Foreground);
	    header.setFont(new Font("Inter",Font.BOLD,(int)(height_Cell*1.0)));
	    this.setForeground(color_Foreground);
	    this.setBorder(BorderFactory.createLineBorder(color_Border));
	    this.setRowHeight(height_Cell);
	    this.setBackground(Color.white);
	    setFillsViewportHeight( true );
	    this.setFont(new Font("Times New Roman",Font.PLAIN,(int)(height_Cell*1.0)));
	}
	
	public Custom_Table(DefaultTableModel tableModel,Color color_Header_Background, Color color_Header_Foreground, Color color_Foreground,
			Color color_StripeForeground, Color color_StripeBackground, Color color_Border,int height_Cell) {
		super(tableModel);
		this.color_Header_Background = color_Header_Background;
		this.color_Header_Foreground = color_Header_Foreground;
		this.color_Foreground = color_Foreground;
		this.color_StripeForeground = color_StripeForeground;
		this.color_StripeBackground = color_StripeBackground;
		this.color_Border = color_Border;
		this.height_Cell = height_Cell;
		redrawn_Custom_Table();
	}
	
	public Custom_Table(DefaultTableModel tableModel) {
		// TODO Auto-generated constructor stub
	      // Thêm bảng vào khung JFrame
		this(tableModel,Custom_ColorPicker.lavender_ED91FF, Color.white, Color.black,Color.black, Custom_ColorPicker.snowwhite_F2F0EB, Custom_ColorPicker.lavender_ED91FF,30);
	}
	public Custom_Table() {
		// TODO Auto-generated constructor stub
	      // Thêm bảng vào khung JFrame
		this(new DefaultTableModel(new String[] {"Alo","Bee"},3));
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
		
	}
	
	public void xoaTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.getModel();
        dtm.getDataVector().removeAllElements();
    }
    public void resetShowTable() {
        this.setVisible(false);
        this.setVisible(true);
    }
    public void align(int align,int column) {
    	
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    	if(align == 2) {
    		renderer.setHorizontalAlignment( JLabel.RIGHT );
    		this.getColumnModel().getColumn(column).setCellRenderer(renderer);
    	}
	}
    public void align(int align,int column[]) {
    	for (int i = 0; i < column.length; i++) {
			align(align, column[i]);
		}
	}
    public Component prepareRenderer( TableCellRenderer renderer, int row, int column )
	  {
	    Component c = super.prepareRenderer( renderer, row, column );

	    if ( !isRowSelected( row ) )
	    {
	      c.setBackground( row % 2 == 0 ? getBackground() :color_StripeBackground );
	      c.setForeground( row % 2 == 0 ? getForeground() : color_StripeForeground);

	    }

	    return c;
	  }
}
