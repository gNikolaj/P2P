    package com.shpp.p2p.cs.ngrishchenko.assignment7.namesurfer;

    /*
     * File: NameSurferGraph.java
     * ---------------------------
     * This class represents the canvas on which the graph of
     * names is drawn. This class is responsible for updating
     * (redrawing) the graphs whenever the list of entries changes
     * or the window is resized.
     */

    import acm.graphics.*;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;

    public class NameSurferGraph extends GCanvas
            implements NameSurferConstants, ComponentListener {
        private ArrayList<NameSurferEntry> nseList = new ArrayList<>();

        /**
         * Creates a new NameSurferGraph object that displays the data.
         */
        public NameSurferGraph() {
            addComponentListener(this);
            update();
        }

        /**
         * Clears the list of name surfer entries stored inside this class.
         */
        public void clear() {
            nseList.clear();
            update();
        }

        /* Method: addEntry(entry) */

        /**
         * Adds a new NameSurferEntry to the list of entries on the display.
         * Note that this method does not actually draw the graph, but
         * simply stores the entry; the graph is drawn by calling update.
         */
        public void addEntry(NameSurferEntry entry) {
            if (entry != null) {
                nseList.add(entry);
            } else {
                System.out.println("Try one more time!");
            }
            update();
        }

        /**
         * Updates the display image by deleting all the graphical objects
         * from the canvas and then reassembling the display according to
         * the list of entries. Your application must call update after
         * calling either clear or addEntry; update is also called whenever
         * the size of the canvas changes.
         */
        public void update() {
            removeAll();
            drawVerticalLines();
            drawHorizontalLines();
            drawDecades();
            drawGraph(nseList);
        }

        private void drawDecades() {
            int step = getWidth() / NDECADES;
            for (int i = 0; i < NDECADES; i++) {
                String year = String.valueOf((START_DECADE + i * 10));
                GLabel l = new GLabel(year);
                l.setFont(new Font("Arial", Font.BOLD, (step + GRAPH_MARGIN_SIZE) / 5));
                add(l, step * i, getHeight());
            }
        }

        /**
         * Method draws graph
         * It contains drawing lines for graph and labels with names and ranks
         * @param list - contains name and ranks
         */
        private void drawGraph(ArrayList<NameSurferEntry> list) {
            int stepX = getWidth() / NDECADES;
            /** Var for correct changing size when move window walls*/
            double changeY = (double)(getHeight() - 2 * GRAPH_MARGIN_SIZE) / MAX_RANK;

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.size());
                NameSurferEntry currentEntry = list.get(i);
                for (int j = 0; j < NDECADES; j++) {
                    int rank = currentEntry.getRank(j);

                    if (rank == 0) rank = MAX_RANK;

                    /** Make this condition cause I use previous param(j-1)*/
                    if (j != 0) {
                        int previousRank = currentEntry.getRank(j-1);
                        if (previousRank == 0) previousRank = MAX_RANK;
                        double x1Position = stepX * j;
                        double y1Position = GRAPH_MARGIN_SIZE + rank * changeY;
                        double x0Position = stepX * (j-1);
                        double y0Position = GRAPH_MARGIN_SIZE + previousRank * changeY;

                        GLine l = new GLine(x0Position, y0Position, x1Position, y1Position);
                        setColor(l, i);
                        add(l);
                    }

                    String result = currentEntry.getName() + " " + rank;
                    if (rank == MAX_RANK) result = currentEntry.getName() + " *";

                    GLabel nameAndRank = addLabel(result, i);
                    add(nameAndRank, stepX * j, GRAPH_MARGIN_SIZE + rank * changeY);
                }
            }
        }

        /**
         * Method generate colors for graphs
         * @param line - line that will be used in graph
         * @param i - to generate color
         */
        private void setColor(GObject line, int i) {
            Color [] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.BLACK };
            line.setColor(colors[i % colors.length]);
        }

        /**
         * Method create label
         * @param label - text that will added in label
         * @param i - to chose color in another method
         * @return label with text
         */
        private GLabel addLabel(String label, int i) {
            GLabel l = new GLabel(label);
            l.setFont(new Font("Arial", Font.BOLD, 10));
            setColor(l, i);
            return l;
        }

        /**
         * Method draws two horizontal lines
         */
        private void drawHorizontalLines() {
            GLine l1 = new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE);
            GLine l2 = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE);
            add(l1);
            add(l2);
        }

        /**
         * Method draws all vertical lines
         */
        private void drawVerticalLines() {
            int step = getWidth() / NDECADES;
            for (int i = 0; i < NDECADES; i++) {
                GLine l = new GLine(step * i, 0, step * i, getHeight());
                add(l);
            }
        }

        /* Implementation of the ComponentListener interface */
        public void componentHidden(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentResized(ComponentEvent e) {
            update();
        }

        public void componentShown(ComponentEvent e) {
        }
    }
