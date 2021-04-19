package com.shpp.p2p.cs.ngrishchenko.assignment7.namesurfer;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import com.shpp.cs.a.simple.SimpleProgram;

import javax.swing.*;
import java.awt.event.*;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {

    private JButton graphButton;
    private JButton clearButton;
    private JTextField nameField;
    private NameSurferDataBase nsdb = new NameSurferDataBase(NAMES_DATA_FILE);
    private NameSurferGraph graph;

	/* Method: init() */

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */
    public void init() {
        JLabel nameLabel;
        add(nameLabel = new JLabel("Name: "), NORTH);
        add(nameField = new JTextField(TEXT_FIELD_WIDTH), NORTH);
        nameField.setActionCommand("Enter word");
        nameField.addActionListener(this);
        add(graphButton = new JButton("Graph"), NORTH);
        add(this.clearButton = new JButton("Clear"), NORTH);
        addActionListeners();

        graph = new NameSurferGraph();
        add(graph);
    }

	/* Method: actionPerformed(e) */

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            graph.clear();
        } else if (e.getSource() == graphButton) {
            NameSurferEntry nse = nsdb.findEntry(nameField.getText());
            graph.addEntry(nse);
        } else if (e.getActionCommand().equals("Enter word")) {
            NameSurferEntry nse = nsdb.findEntry(nameField.getText());
            graph.addEntry(nse);
        }
    }
}
