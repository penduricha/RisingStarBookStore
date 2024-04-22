package customEntities;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class Custom_JTextField extends JTextField {

    public static void main(final String[] args) {
        final Custom_JTextField tf = new Custom_JTextField("");
        tf.setColumns(20);
        tf.setPlaceholder("All your base are belong to us!");
        final Font f = tf.getFont();
        tf.setFont(new Font(f.getName(), f.getStyle(), 30));
        JOptionPane.showMessageDialog(null, tf);
    }

    private String placeholder;

    public Custom_JTextField() {
    }

    public Custom_JTextField(
        final Document pDoc,
        final String pText,
        final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public Custom_JTextField(final int pColumns) {
        super(pColumns);
    }

    public Custom_JTextField(final String pText) {
        super(pText);
    }

    public Custom_JTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman",Font.PLAIN,30));
        g.drawString(placeholder, 5, 50);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}