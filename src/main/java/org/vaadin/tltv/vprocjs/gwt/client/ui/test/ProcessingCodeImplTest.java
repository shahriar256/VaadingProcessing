package org.vaadin.tltv.vprocjs.gwt.client.ui.test;

import org.vaadin.tltv.vprocjs.gwt.client.ui.ProcessingCodeBase;


import java.awt.*;


import static com.vaadin.icons.VaadinIcons.CLOSE;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.TOP;



public class ProcessingCodeImplTest extends ProcessingCodeBase {

    double radius = 50.0f;
    int X, Y;
    int nX, nY;
    int delay = 16;

    public static RadarChart rc;
    public static Axis[] axes;
    public static int[] points = new int[21];
    public static float ang;
    int talent = 10;
    int technology = 10;
    int tolerance = 10;
    int innovative = 10;
    int capitals = 10;
    int resource = 10;
    int community = 10;
    int tools = 10;
    int communication = 10;
    int cooperation = 10;
    int culture = 10;
    int city = 10;
    int creative = 10;
    int people = 10;
    int environment = 10;
    int mobility = 10;
    int economy = 10;
    int living = 10;
    int governance = 10;
    int smart = 10;
    int built_Environment = 10;
    float maxTalent = 10;
    float maxTechnology = 10;
    float maxTolerance = 10;
    float maxCulture = 10;
    float maxCommunication = 10;
    float maxCooperation = 10;
    public static int Articleid = 1;
    public static String title = null;
    public static Object a = new Object() ;


    public static int count = 0;

    public static int id1 = 0;
    public static int id2 = 0;
    public static float attractionFactor;
    public static String type;
    public static int width=600;
    public static int height=600;

    @Override
    public void setup() {
        pro.frameRate(30);
        pro.background(255);
        pro.size(width, height);
        pro.stroke(0);
        setupRadarChart();
    }

    @Override
    public void draw() {

        plotRadarChart();

    }

    @Override
    public void mouseMoved() {

    }

    public void setupRadarChart() {


        axes = new Axis[6];
        axes[0] = new Axis(1, "People", "unit");
        axes[1] = new Axis(2, "Governance", "unit");
        axes[2] = new Axis(3, "Mobility", "unit");
        axes[3] = new Axis(4, "Economy", "unit");
        axes[4] = new Axis(5, "Living", "unit");
        axes[5] = new Axis(5, "Environment", "unit");

        rc = new RadarChart(percentX(25), percentX(3), percentX(40), percentY(70), percentX(5), percentY(5), 10, 6, percentX(15), percentY(12)); //6 dimensions, 6 intrevals

        drawChart(); //draw the skeleton chart.
    }
    public void drawChart() {

        pro.stroke(0);
        pro.strokeWeight(1);
        pro.point((int)rc.centerX, (int)rc.centerY);

        rc.axisPointsX = new float[rc.dimensions+2];
        rc.axisPointsY = new float[rc.dimensions+2];
        float xValue;
        float yValue;
        float ang = 30;
        float x1Value;
        float y1Value;
        float x2Value;
        float y2Value;

        for (int i = 0; i < rc.dimensions; i++, ang += rc.angle) {  //increment angle of the axis/dimension drawn i.e. increment by 360/3 deg for a chart of 3 dimentions/axis

            float len = rc.intervalLength;
            rc.axisPointsX[i] = rc.getX(ang, rc.axisLength + rc.labelHeight/3);
            rc.axisPointsY[i] = rc.getY(ang, rc.axisLength + rc.labelHeight/3);
            rc.axisPointsX[rc.dimensions] = rc.getX(-60, rc.axisLength + rc.labelHeight/3);
            rc.axisPointsY[rc.dimensions] = rc.getY(-60, rc.axisLength + rc.labelHeight/3);
            rc.axisPointsX[rc.dimensions+1] = rc.getX(-120, rc.axisLength + rc.labelHeight/3);
            rc.axisPointsY[rc.dimensions+1] = rc.getY(-120, rc.axisLength + rc.labelHeight/3);
            //Color aColor = Color.decode("#ADA5A8");
            pro.stroke(173,165,168);
            pro.strokeWeight(1);
            pro.line(rc.centerX, rc.centerY, rc.axisPointsX[i], rc.axisPointsY[i]);    //draw the axis line
            pro.strokeWeight(1);
            pro.line(rc.centerX, rc.centerY, rc.axisPointsX[rc.dimensions], rc.axisPointsY[rc.dimensions]);    //draw the axis line
            pro.line(rc.centerX, rc.centerY, rc.axisPointsX[rc.dimensions+1], rc.axisPointsY[rc.dimensions+1]);    //draw the axis line

            pro.stroke(0);



            for (int index = 0; index < rc.intervals; index++, len += rc.intervalLength) {
                xValue = rc.getX(ang, len);
                yValue = rc.getY(ang, len);
                x1Value = rc.getX(-60, len);
                y1Value = rc.getY(-60, len);
                x2Value = rc.getX(-120, len);
                y2Value = rc.getY(-120, len);

                pro.strokeWeight(4);  //mark all the interval points on the axes drawn
                pro.stroke(173,165,168);

                pro.point((int)xValue, (int)yValue);

                pro.point((int)x1Value,(int) y1Value);
                pro.point((int)x2Value,(int) y2Value);

                pro.stroke(173,165,168);
                if (i%2==0) {
                    float x11=rc.getX(ang, rc.intervalLength*rc.intervals/3);
                    float y11=rc.getY(ang, rc.intervalLength*rc.intervals/3);
                    float x12=rc.getX(ang, (float) (rc.intervalLength*rc.intervals/1.2));
                    float y12=rc.getY(ang, (float) (rc.intervalLength*rc.intervals/1.2));
                    pro.fill(0);

                    pro.fill(255);
                    pro.ellipse(x11, y11, 20, 20);
                    pro.ellipse(x12, y12, 40, 40);

                }
            }
            displayLabels(ang, axes[i]);


        }
    }
    //X - axis
    int percentX(int value) {
        return (value * width) / 100;
    }

    //Y - axis
    int percentY(int value) {
        return (value * height) / 100;
    }
    public float getX(float ang, float len) {
        return  (float)(rc.centerX + (len *Math.cos(Math.toRadians(ang))));
    }

    //get the x-axis co-ordinate of a point on the axis/dimension being drawn in the radar chart
    public float getY(float ang, float len) {
        return (float)(rc.centerY + (len * Math.sin(Math.toRadians(ang))));
    }

   public void displayLabels(float ang, Axis axis) {
        float xValue = getX(ang,  rc.axisLength +  rc.labelHeight/4);
        float yValue = getY(ang,  rc.axisLength +  rc.labelHeight/4);
        float x11=getX(ang,  rc.intervalLength* rc.intervals/3);
        float y11=getY(ang,  rc.intervalLength* rc.intervals/3);
        float x12=getX(ang, (float) ( rc.intervalLength* rc.intervals/1.2));
        float y12=getY(ang, (float) ( rc.intervalLength* rc.intervals/1.2));
        //Font myFont =new Font ("SansSerif",Font.PLAIN,  11);

        //pro.textFont(myFont,10);
        pro.fill(0);


        if (ang==270) {

            pro.text("Talent", x11, y11-6);
            pro.text("Culture", x12, y12-6);
        }
        if (ang==150) {

            pro.text("Technology", x11, y11-6);
            pro.text("Communication", x12, y12-6);
        }
        if (ang==30) {

            pro.text("Tollerance", x11, y11-6);
            pro.text("Cooperation", x12, y12-6);
        }

        if (ang >= 0 && ang < 90) {
            //pro.textAlign(LEFT, BOTTOM);
            pro.text(axis.Name + " (" + axis.Unit + ")", xValue +  rc.labelWidth/6, yValue +  rc.labelHeight/4);
            float  x1Value = getX(-60, rc.intervalLength*( rc.intervals+1)+ rc.labelWidth/6);
            float y1Value = getY(-60,  rc.intervalLength*( rc.intervals+1)+ rc.labelWidth/6);
            pro.text("Built Environemnt", x1Value, y1Value);
        }
        if (ang >= 90 && ang < 180) {
           // pro.textAlign(LEFT, BOTTOM);
            pro.text(axis.Name + " (" + axis.Unit + ")", xValue -  rc.labelWidth, yValue +  rc.labelHeight/2);

        }
        if (ang >= 180 && ang < 270) {
           // pro.textAlign(LEFT, BOTTOM);
            pro.text(axis.Name + " (" + axis.Unit + ")", xValue -  rc.labelWidth, yValue -  rc.labelHeight/6);
            float  x1Value = getX(-120,  rc.intervalLength*( rc.intervals+1)+ rc.labelWidth/6);
            float y1Value = getY(-120,  rc.intervalLength*( rc.intervals+1)+ rc.labelWidth/6);
            pro.text("Smart", x1Value, y1Value);
        }
        if (ang >= 270 && ang < 360) {
           // pro.textAlign(LEFT, BOTTOM);
            pro.text(axis.Name + " (" + axis.Unit + ")", xValue, yValue -  rc.labelHeight/6);
        }
    }



    public void plotRadarChart() {

        points[0] = talent;
        points[2] = technology;
        points[3] = tolerance;

        points[1] = (innovative + points[0] + points[2]) / 3;
        points[4] = (capitals + points[0] + points[3]) / 3;

        points[20] = resource / 7;
        points[19] = community / 5;
        points[18] = tools / 5;
        points[7] = (int) (communication + points[18] + points[2]) / 2;
        points[8] = (int) (cooperation + points[19] + points[3]) / 2;
        points[5] = (int) (culture + points[20] + points[0]) / 2;
        points[9] = points[19] + points[20] + (city + points[5] + points[8] + points[0] + points[3] + points[4]) / 6;
        points[6] = points[18] + points[20] + (creative + points[5] + points[0] + points[2] + points[1] + points[7]) / 6;
        points[15] = points[19] + (people + points[8] + points[3]) / 3;
        points[16] = (points[20] + points[19]) / 2 + (environment + points[4] + points[9]) / 3;
        points[13] = points[18] + (mobility + points[7] + points[2]) / 3;
        points[12] = (points[18] + points[20]) / 2 + (economy + points[1] + points[6]) / 3;
        points[10] = points[20] + (living + points[0] + points[5]) / 3;
        points[14] = (points[18] + points[19]) / 2 + (governance + points[13] + points[8] + points[7] + points[15]) / 5;
        points[11] = (points[20]) / 2 + (smart + points[12] + points[6] + points[10] + points[5]) / 5;
        points[17] = points[20] / 2 + (built_Environment + points[16] + points[10] + points[5] + points[9]) / 5;
        float max = 0;
        float[] map = new float[21];
        for (int i = 0; i < 21; i++) {
            if (points[i] > 10) {
                // max = points[i];
                points[i] = (int) pro.map(points[i], 0, points[i], 0, 10);
            }
            //System.out.println(points[i]);
            // noLoop();

        }
        // System.out.println(max);
        float[] xValue = new float[5];
        float[] yValue = new float[5];


        xValue[0] = rc.getX(-90, points[0] * rc.intervalLength / 3);
        yValue[0] = rc.getY(-90, points[0] * rc.intervalLength / 3);
        xValue[1] = rc.getX(-150, points[1] * rc.intervalLength / 3);
        yValue[1] = rc.getY(-150, points[1] * rc.intervalLength / 3);
        xValue[2] = rc.getX(-210, points[2] * rc.intervalLength / 3);
        yValue[2] = rc.getY(-210, points[2] * rc.intervalLength / 3);
        xValue[3] = rc.getX(-330, points[3] * rc.intervalLength / 3);
        yValue[3] = rc.getY(-330, points[3] * rc.intervalLength / 3);
        xValue[4] = rc.getX(-30, points[4] * rc.intervalLength / 3);
        yValue[4] = rc.getY(-30, points[4] * rc.intervalLength / 3);

        pro.stroke(255, 0, 0);
        for (int i = 0; i < 5; i++) {
            pro.strokeWeight(10);
            pro.point((int)xValue[i],(int) yValue[i]);
        }

        float[] xValue1 = new float[5];
        float[] yValue1 = new float[5];


        xValue1[0] = rc.getX(-90, (float) (points[5] * rc.intervalLength / 1.2));
        yValue1[0] = rc.getY(-90, (float) (points[5] * rc.intervalLength / 1.2));
        xValue1[1] = rc.getX(-150, (float) (points[6] * rc.intervalLength / 1.2));
        yValue1[1] = rc.getY(-150, (float) (points[6] * rc.intervalLength / 1.2));
        xValue1[2] = rc.getX(-210, (float) (points[7] * rc.intervalLength / 1.2));
        yValue1[2] = rc.getY(-210, (float) (points[7] * rc.intervalLength / 1.2));
        xValue1[3] = rc.getX(-330, (float) (points[8] * rc.intervalLength / 1.2));
        yValue1[3] = rc.getY(-330, (float) (points[8] * rc.intervalLength / 1.2));
        xValue1[4] = rc.getX(-30, (float) (points[9] * rc.intervalLength / 1.2));
        yValue1[4] = rc.getY(-30, (float) (points[9] * rc.intervalLength / 1.2));

        pro.stroke(255, 140, 0);
        for (int i = 0; i < 5; i++) {
            pro.strokeWeight(10);
            pro.point((int)xValue1[i],(int) yValue1[i]);
        }
//        tint(255, 100);


        float[] xValue2 = new float[8];
        float[] yValue2 = new float[8];


        xValue2[0] = rc.getX(-90, points[10] * rc.intervalLength);
        yValue2[0] = rc.getY(-90, (float) (points[10] * rc.intervalLength));
        xValue2[1] = rc.getX(-120, (float) (points[11] * rc.intervalLength));
        yValue2[1] = rc.getY(-120, (float) (points[11] * rc.intervalLength));
        xValue2[2] = rc.getX(-150, (float) (points[12] * rc.intervalLength));
        yValue2[2] = rc.getY(-150, (float) (points[12] * rc.intervalLength));
        xValue2[3] = rc.getX(-210, (float) (points[13] * rc.intervalLength));
        yValue2[3] = rc.getY(-210, (float) (points[13] * rc.intervalLength));
        xValue2[4] = rc.getX(-270, (float) (points[14] * rc.intervalLength));
        yValue2[4] = rc.getY(-270, (float) (points[14] * rc.intervalLength));
        xValue2[5] = rc.getX(-330, (float) (points[15] * rc.intervalLength));
        yValue2[5] = rc.getY(-330, (float) (points[15] * rc.intervalLength));
        xValue2[6] = rc.getX(-30, (float) (points[16] * rc.intervalLength));
        yValue2[6] = rc.getY(-30, (float) (points[16] * rc.intervalLength));
        xValue2[7] = rc.getX(-60, (float) (points[17] * rc.intervalLength));
        yValue2[7] = rc.getY(-60, (float) (points[17] * rc.intervalLength));

        pro.stroke(255, 215, 0);
        for (int i = 0; i < 8; i++) {
            pro.strokeWeight(10);
            pro.point((int)xValue2[i], (int)yValue2[i]);
        }

        float deg = 0;
        double rad =  pro.radians(deg);


        pro.stroke(255, 215, 0);
        pro.strokeWeight(3);
        pro.fill(255, 215, 0, 100);

        pro.beginShape(a);

        pro.vertex(xValue2[0], yValue2[0]);
        pro.vertex(xValue2[1], yValue2[1]);
        pro.vertex(xValue2[2], yValue2[2]);
        pro.vertex(xValue2[3], yValue2[3]);
        pro.vertex(xValue2[4], yValue2[4]);
        pro.vertex(xValue2[5], yValue2[5]);
        pro.vertex(xValue2[6], yValue2[6]);
        pro.vertex(xValue2[7], yValue2[7]);


        pro.endShape();
        pro.stroke(255, 140, 0);
        pro.strokeWeight(3);
        pro.fill(255, 140, 0, 100);

        pro.beginShape(a);

        pro.vertex(xValue1[0], yValue1[0]);
        pro.vertex(xValue1[1], yValue1[1]);
        pro.vertex(xValue1[2], yValue1[2]);
        pro.vertex(xValue1[3], yValue1[3]);
        pro.vertex(xValue1[4], yValue1[4]);

        pro.endShape();
        pro.stroke(255, 69, 0);
        pro.strokeWeight(3);
        pro.fill(255, 0, 0, 100);
        //tint(0, 100);

        pro.beginShape(a);

        pro.vertex(xValue[0], yValue[0]);
        pro.vertex(xValue[1], yValue[1]);
        pro.vertex(xValue[2], yValue[2]);
        pro.vertex(xValue[3], yValue[3]);
        pro. vertex(xValue[4], yValue[4]);

        pro.endShape();
        pro.noFill();
        pro. stroke(0, 191, 255);
        pro.strokeWeight(6);
        int vertexX0 = (int)rc.getX(-90,  (10 * rc.intervalLength / 3));
        int vertexY0 =(int) rc.getY(-90,  (10 * rc.intervalLength / 3));
        int vertexX1 =(int) rc.getX(-210, (10 * rc.intervalLength / 3));
        int vertexY1 = (int)rc.getY(-210,  (10 * rc.intervalLength / 3));
        int vertexX2 =(int) rc.getX(-330,  (10 * rc.intervalLength / 3));
        int vertexY2 =(int) rc.getY(-330, (10 * rc.intervalLength / 3));
        double talent0 = pro.map (talent, 0, maxTalent, 0, 360);
        double technology0 = pro.map(technology, 0, maxTechnology, 0, 360);
        double tolerance0 = pro.map (tolerance, 0, maxTolerance, 0, 360);

        double culture0 = pro.map(culture, 0, maxCulture, 0, 360);
        double communication0 = pro.map(communication, 0, maxCommunication, 0, 360);
        double cooperation0 = pro.map(cooperation, 0, maxCooperation, 0, 360);
        pro. arc(vertexX0, vertexY0, 15, 15,(int) - Math.PI / 2,(int)  pro.radians(talent0));
        pro.arc(vertexX1, vertexY1, 15, 15, (int)-Math.PI / 2, (int) pro.radians(technology0));
        pro.arc(vertexX2, vertexY2, 15, 15,(int) -Math.PI / 2, (int) pro.radians(tolerance0));
        pro.stroke(0, 191, 255);

        pro.strokeWeight(10);

        int pointX;
        int pointY;
        int pointX0 =(int) rc.getX(-90, (int)(10 * rc.intervalLength / 1.2));
        int pointY0 = (int)rc.getY(-90, (float) (10 * rc.intervalLength / 1.2));
        pointX = (int)rc.getX(-210, (float) (10 * rc.intervalLength / 1.2));
        pointY = (int)rc.getY(-210, (float) (10 * rc.intervalLength / 1.2));
        int point1 = points[8] - 1;
        int pointX1;
        int pointY1;
        pointX1 =(int) rc.getX(-330, (float) (10 * rc.intervalLength / 1.2));
        pointY1 =(int) rc.getY(-330, (float) (10 * rc.intervalLength / 1.2));

        pro.arc(pointX0, pointY0, 30, 30,(int) -Math.PI / 2, (int) pro.radians(culture0));
        pro.arc(pointX, pointY, 30, 30, (int)-Math.PI / 2, (int) pro.radians(communication0));
        pro.arc(pointX1, pointY1, 30, 30, (int)-Math.PI / 2,(int) pro. radians(cooperation0));
        pro.strokeWeight(1);
    }
}
