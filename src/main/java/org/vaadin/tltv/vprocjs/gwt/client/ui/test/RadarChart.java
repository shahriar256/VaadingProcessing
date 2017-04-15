package org.vaadin.tltv.vprocjs.gwt.client.ui.test;

import org.vaadin.tltv.vprocjs.gwt.client.ui.ProcessingCodeBase;
//import processing.core.PApplet;

import java.awt.*;

import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.TOP;
import static org.vaadin.tltv.vprocjs.gwt.client.ui.test.ProcessingCodeImplTest.width;



/**
 * Created by Shahriar on 4/6/2017.
 */

public class RadarChart extends ProcessingCodeImplTest {
    //public static Axis[]axes;
    float X;
    float Y;
    float chartWidth;
    float chartHeight;
    float angle;
    float marginWidth;
    float marginHeight;
    float centerX;
    float centerY;
    float axisLength;
    int intervals;
    float intervalLength;
    int distance = 5;
    int dimensions;
    int labelWidth;
    int labelHeight;
    float[] axisPointsX;
    float[] axisPointsY;
    float [] innerCircle;


    //Constructor - sets margin width, margin height, number of intervals on the axes to default values
   public RadarChart(float _X, float _Y, float _chartWidth, float _chartHeight, int dim) {

        dimensions = dim;
        angle = 360 / dim;
        marginWidth = 50;  //default values - edit defaults of use the construtor over load.
        marginHeight = 50; //default values - edit defaults of use the construtor over load.
        X = _X + marginWidth;
        Y = _Y + marginHeight;
        chartWidth = _chartWidth - (marginWidth * 2);
        chartHeight = _chartHeight - (marginHeight * 2);
        centerX = _X + (width);
        centerY = _Y + (height);
        axisLength = chartHeight/2 - marginHeight;
        intervals = 10; //number of intervals on the axes
        intervalLength = axisLength/(intervals);
    }

    //Constructor - accepts all user input values
    public RadarChart(float _X, float _Y, float _chartWidth, float _chartHeight, float _marginWidth, float _marginHeight,
                      int _intervals, int dim, int lblWidth, int lblHeight) {

        dimensions = dim;
        angle = 360 / dim;
        marginWidth = _marginWidth;
        marginHeight = _marginHeight;
        X = _X + marginWidth;
        Y = _Y + marginHeight;
        chartWidth = _chartWidth - (marginWidth * 2);
        chartHeight = _chartHeight - (marginHeight * 2);
        centerX = _X + (_chartWidth/2);
        centerY = _Y + (_chartHeight/2);
        axisLength = chartHeight/2 - marginHeight;
        intervals = _intervals;
        intervalLength = axisLength/(intervals);
        labelHeight = lblHeight;
        labelWidth = lblWidth;
    }

    public void setDimensions(int dim) {  //to change the number of dimensions of the chart dynamically. Chart will have to be redrawn after this or drawChart() should be invoked in draw()
        dimensions = dim;
        angle = 360 / dimensions;
    }

    /*public void drawChart() {

        pro.stroke(0);
        pro.strokeWeight(1);
        pro.point((int)centerX, (int)centerY);

        axisPointsX = new float[dimensions+2];
        axisPointsY = new float[dimensions+2];
        float xValue;
        float yValue;
        float ang = 30;
        float x1Value;
        float y1Value;
        float x2Value;
        float y2Value;

        for (int i = 0; i < dimensions; i++, ang += angle) {  //increment angle of the axis/dimension drawn i.e. increment by 360/3 deg for a chart of 3 dimentions/axis

            float len = intervalLength;
            axisPointsX[i] = getX(ang, axisLength + labelHeight/3);
            axisPointsY[i] = getY(ang, axisLength + labelHeight/3);
            axisPointsX[dimensions] = getX(-60, axisLength + labelHeight/3);
            axisPointsY[dimensions] = getY(-60, axisLength + labelHeight/3);
            axisPointsX[dimensions+1] = getX(-120, axisLength + labelHeight/3);
            axisPointsY[dimensions+1] = getY(-120, axisLength + labelHeight/3);
            //Color aColor = Color.decode("#ADA5A8");
            pro.stroke(173,165,168);
            pro.strokeWeight(1);
            pro.line(centerX, centerY, axisPointsX[i], axisPointsY[i]);    //draw the axis line
            pro.strokeWeight(1);
            pro.line(centerX, centerY, axisPointsX[dimensions], axisPointsY[dimensions]);    //draw the axis line
            pro.line(centerX, centerY, axisPointsX[dimensions+1], axisPointsY[dimensions+1]);    //draw the axis line

            pro.stroke(0);



            for (int index = 0; index < intervals; index++, len += intervalLength) {
                xValue = getX(ang, len);
                yValue = getY(ang, len);
                x1Value = getX(-60, len);
                y1Value = getY(-60, len);
                x2Value = getX(-120, len);
                y2Value = getY(-120, len);
                //ellipse();
                pro.strokeWeight(4);  //mark all the interval points on the axes drawn
                pro.stroke(173,165,168);

                pro.point((int)xValue, (int)yValue);

                pro.point((int)x1Value,(int) y1Value);
                pro.point((int)x2Value,(int) y2Value);

                pro.stroke(173,165,168);
                if (i%2==0) {
                    float x11=getX(ang, intervalLength*intervals/3);
                    float y11=getY(ang, intervalLength*intervals/3);
                    float x12=getX(ang, (float) (intervalLength*intervals/1.2));
                    float y12=getY(ang, (float) (intervalLength*intervals/1.2));
                    pro.fill(0);

                    pro.fill(255);
                    pro.ellipse(x11, y11, 20, 20);
                    pro.ellipse(x12, y12, 40, 40);

                }
            }
            //displayLabels(ang, ProcessingCodeImplTest.axes[i]);


        }
    }*/

    //get the x-axis co-ordinate of a point on the axis/dimension being drawn in the radar chart



  /*display labels at the end of each axis.
   To avoid the labels from overlapping over its own axis. The labels are positioned according to the quardant they are present in.
   I quadrant - text aligned left and bottom
   II quadrant - text aligned left and bottom but extra padding provided to the x and y co ordinates
   III quadrant - txt aligned left and bottom with padding to the y axis and x axis co-ordinate reduced by a label's width
   IV quadrant - text aligned left and bottom and x axis co-ordinate  reduced by a label's width
   */


}
