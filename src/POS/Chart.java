package POS;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Chart extends JFrame {


    public Chart() throws SQLException {
        super("Day Sales");
        JFreeChart barChart = ChartFactory.createBarChart
                ("Day Sales", "", "", createDataset(), PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() throws SQLException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dbconn db = new dbconn();
        db.select("select *from daysales order by day");
        while (db.rs.next()) {
            dataset.addValue(db.rs.getInt("sales"), db.rs.getString("day"), db.rs.getString("day"));
        }
        return dataset;
    }
    


}
