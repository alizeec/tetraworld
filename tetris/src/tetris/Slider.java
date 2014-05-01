package tetris;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider {
  JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);

  public Slider() {
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(50);
    slider.setMinorTickSpacing(10);
    slider.setPaintLabels(true);
    Hashtable ht = slider.createStandardLabels(50);
    slider.setLabelTable(ht);

    slider.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        System.out.println("Slider: " + slider.getValue());
      }
    });
  }

  public static void main(String[] args) {
    new Slider();
  }
}