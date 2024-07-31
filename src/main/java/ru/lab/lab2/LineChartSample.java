package ru.lab.lab2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;




public class LineChartSample extends Application {

//    private List<Double> angX;
//    private List<Double> angY;
//    private List<Double> angZ;


//    public List<Double> getAngX()
//    {
//        System.out.println(angX);
//        return angX;
//    }
//
//    public List<Double> getAngY()
//    {
//        System.out.println(angY);
//        return angY;
//    }
//
//    public List<Double> getAngZ()
//    {
//        System.out.println(angZ);
//        return angZ;
//    }



    @Override public void start(Stage stage) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\Apelsina8\\IdeaProjects\\lab2\\src\\main\\resources\\data1.csv"));

        // считываем построчно
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Employee> empList = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Employee emp = new Employee();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    emp.setTime(Double.parseDouble(data));
                else if (index == 1)
                    emp.setAcc_x(Integer.parseInt(data));
                else if (index == 2)
                    emp.setAcc_y(Integer.parseInt(data));
                else if (index == 3)
                    emp.setAcc_z(Integer.parseInt(data));
                else if (index == 4)
                    emp.setGyro_x(Integer.parseInt(data));
                else if (index == 5)
                    emp.setGyro_Y(Integer.parseInt(data));
                else if (index == 6)
                    emp.setGyro_z(Integer.parseInt(data));
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            empList.add(emp);
        }

        //закрываем наш ридер
        reader.close();

        List<Double> time = new ArrayList<>();
        List<Double> acc_x = new ArrayList<>();
        List<Double> acc_y = new ArrayList<>();
        List<Double> acc_z = new ArrayList<>();
        List<Double> gyro_x = new ArrayList<>();
        List<Double> gyro_y = new ArrayList<>();
        List<Double> gyro_z = new ArrayList<>();
        List<Double> acc_xx = new ArrayList<>();
        List<Double> acc_yy = new ArrayList<>();
        List<Double> gyro_xx = new ArrayList<>();
        List<Double> gyro_yy = new ArrayList<>();
        List<Double> gyro_zz = new ArrayList<>();


        for (int i = 0; i < empList.size(); i++) {
            time.add(i, empList.get(i).getTime());
            acc_x.add(i, (double) empList.get(i).getAcc_x() / 16384);
            acc_y.add(i, (double) empList.get(i).getAcc_y() / 16384);
            acc_z.add(i, (double) empList.get(i).getAcc_z() / 16384);
            gyro_x.add(i, (double) empList.get(i).getGyro_x() / 131);
            gyro_y.add(i, (double) empList.get(i).getGyro_Y() / 131);
            gyro_z.add(i, (double) empList.get(i).getGyro_z() / 131);
        }

//        System.out.println(time);
//        System.out.println(gyro_y);

        //System.out.println(empList);
        Scanner scanner1 = new Scanner(System.in);

        stage.setTitle("LAB1");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("время, c");

        System.out.println("Task1 or Task2?");
        String task = scanner1.next();
        if (task.equals("task1")) {
            System.out.println("Acc or Guro?");
            String accOrGuro = scanner1.next();

            if (accOrGuro.equals("acc")) {
                System.out.println("X, Y, Z?");
                String axis = scanner1.next();
                switch (axis) {
                    case "x":

                        yAxis.setLabel("ускорение по оси Х, м2/с");

                        final ScatterChart<Number, Number> lineChart1 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart1.setTitle("Изменение ускорения по оси X");
                        //defining a series
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series1.getData().add(new XYChart.Data(time.get(i), acc_x.get(i)));
                        }
                        Scene scene1 = new Scene(lineChart1, 2200, 900);
                        lineChart1.getData().add(series1);

                        stage.setScene(scene1);
                        stage.show();

                        break;
                    case "y":

                        yAxis.setLabel("ускорение по оси Z, м2/с");

                        final ScatterChart<Number, Number> lineChart2 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart2.setTitle("Изменение ускорения по оси Y");
                        //defining a series
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series2.getData().add(new XYChart.Data(time.get(i), acc_y.get(i)));
                        }
                        Scene scene2 = new Scene(lineChart2, 2200, 900);
                        lineChart2.getData().add(series2);

                        stage.setScene(scene2);
                        stage.show();

                        break;
                    case "z":

                        yAxis.setLabel("ускорение по оси Z, м2/с");

                        final ScatterChart<Number, Number> lineChart3 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart3.setTitle("Изменение ускорения по оси Z");
                        //defining a series
                        XYChart.Series series3 = new XYChart.Series();
                        series3.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series3.getData().add(new XYChart.Data(time.get(i), acc_z.get(i)));
                        }
                        Scene scene3 = new Scene(lineChart3, 2200, 900);
                        lineChart3.getData().add(series3);

                        stage.setScene(scene3);
                        stage.show();

                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            } else if (accOrGuro.equals("guro")) {

                System.out.println("X, Y, Z?");
                String axis = scanner1.next();
                switch (axis) {
                    case "x":

                        yAxis.setLabel("угловая скорость по оси Х, град/с");

                        final ScatterChart<Number, Number> lineChart1 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart1.setTitle("Изменение ускорения по оси");
                        //defining a series
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series1.getData().add(new XYChart.Data(time.get(i), gyro_x.get(i)));
                        }
                        Scene scene1 = new Scene(lineChart1, 2200, 900);
                        lineChart1.getData().add(series1);

                        stage.setScene(scene1);
                        stage.show();

                        break;
                    case "y":

                        yAxis.setLabel("угловая скорость по оси Y, град/с");

                        final ScatterChart<Number, Number> lineChart2 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart2.setTitle("Изменение ускорения по оси");
                        //defining a series
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series2.getData().add(new XYChart.Data(time.get(i), gyro_y.get(i)));
                        }
                        Scene scene2 = new Scene(lineChart2, 2200, 900);
                        lineChart2.getData().add(series2);

                        stage.setScene(scene2);
                        stage.show();

                        break;
                    case "z":

                        yAxis.setLabel("угловая скорость по оси Z, град/с");

                        final ScatterChart<Number, Number> lineChart3 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart3.setTitle("Изменение ускорения по оси");
                        //defining a series
                        XYChart.Series series3 = new XYChart.Series();
                        series3.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series3.getData().add(new XYChart.Data(time.get(i), gyro_z.get(i)));
                        }
                        Scene scene3 = new Scene(lineChart3, 2200, 900);
                        lineChart3.getData().add(series3);

                        stage.setScene(scene3);
                        stage.show();

                        break;
                    default:
                        System.out.println("Incorrect input!");
                }

            } else {
                System.out.println("Incorrect input!");
            }

            System.out.println("Частота измерения ИИМ: " + empList.size() / (time.get(time.size() - 1) - (time.get(0))));

            for (int i = 0; i < empList.size(); i++) {
                acc_xx.add(90 - Math.acos(acc_x.get(i)));
                acc_yy.add(90 - Math.acos(acc_y.get(i)));
            }

            gyro_xx.add(gyro_x.getFirst());
            gyro_yy.add(gyro_y.getFirst());
            gyro_zz.add(gyro_z.getFirst());

            for (int i = 1; i < empList.size(); i++) {
                gyro_xx.add(gyro_xx.get(i - 1) + gyro_x.get(i) * time.getLast() - time.getFirst());
                gyro_yy.add(gyro_yy.get(i - 1) + gyro_y.get(i) * time.getLast() - time.getFirst());
                gyro_zz.add(gyro_zz.get(i - 1) + gyro_z.get(i) * time.getLast() - time.getFirst());
            }

            List<Double> ang_x = new ArrayList<>();
            List<Double> ang_y = new ArrayList<>();
            List<Double> ang_z = new ArrayList<>();

            for (int i = 0; i < empList.size(); i++) {
                ang_x.add(0.9 * gyro_xx.get(i) + (1 - 0.9) * acc_xx.get(i));
                ang_y.add(0.9 * gyro_yy.get(i) + (1 - 0.9) * acc_yy.get(i));
                ang_z.add(gyro_zz.get(i));
            }

        }
        else if (task.equals("task2")){


            for (int i = 0; i < empList.size(); i++) {
                acc_xx.add(90 - Math.acos(acc_x.get(i)));
                acc_yy.add(90 - Math.acos(acc_y.get(i)));
            }

            gyro_xx.add(gyro_x.getFirst());
            gyro_yy.add(gyro_y.getFirst());
            gyro_zz.add(gyro_z.getFirst());

            for (int i = 1; i < empList.size(); i++) {
                gyro_xx.add(gyro_xx.get(i - 1) + gyro_x.get(i) * time.getLast() - time.getFirst());
                gyro_yy.add(gyro_yy.get(i - 1) + gyro_y.get(i) * time.getLast() - time.getFirst());
                gyro_zz.add(gyro_zz.get(i - 1) + gyro_z.get(i) * time.getLast() - time.getFirst());
            }

            List<Double> ang_x = new ArrayList<>();
            List<Double> ang_y = new ArrayList<>();
            List<Double> ang_z = new ArrayList<>();

            for (int i = 0; i < empList.size(); i++) {
                ang_x.add(0.9 * gyro_xx.get(i) + (1 - 0.9) * acc_xx.get(i));
                ang_y.add(0.9 * gyro_yy.get(i) + (1 - 0.9) * acc_yy.get(i));
                ang_z.add(gyro_zz.get(i));
            }

            List<Double> ugEx = new ArrayList<>();
            List<Double> ugEy = new ArrayList<>();
            List<Double> ugEz = new ArrayList<>();

            ugEx.add(ang_x.get(0));
            ugEy.add(ang_y.get(0));
            ugEz.add(ang_z.get(0));


            for (int i = 1; i < empList.size(); i++) {
                ugEx.add(acc_x.get(i) + acc_x.get(i-1));
                ugEy.add(acc_y.get(i) + acc_y.get(i-1));
                ugEz.add(gyro_zz.get(i));
            }


            System.out.println("Изменение углового перемещения какой оси вы хотите увидить?");
                String axis = scanner1.next();
                switch (axis) {
                    case "x":

                        yAxis.setLabel("ускорение по оси Х, м2/с");

                        final ScatterChart<Number, Number> lineChart1 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart1.setTitle("Изменение ускорения по оси X");
                        //defining a series
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series1.getData().add(new XYChart.Data(time.get(i), ugEx.get(i)));
                        }
                        Scene scene1 = new Scene(lineChart1, 2200, 900);
                        lineChart1.getData().add(series1);

                        stage.setScene(scene1);
                        stage.show();

                        break;
                    case "y":

                        yAxis.setLabel("ускорение по оси Z, м2/с");

                        final ScatterChart<Number, Number> lineChart2 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart2.setTitle("Изменение ускорения по оси Y");
                        //defining a series
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series2.getData().add(new XYChart.Data(time.get(i), ugEy.get(i)));
                        }
                        Scene scene2 = new Scene(lineChart2, 2200, 900);
                        lineChart2.getData().add(series2);

                        stage.setScene(scene2);
                        stage.show();

                        break;
                    case "z":

                        yAxis.setLabel("ускорение по оси Z, м2/с");

                        final ScatterChart<Number, Number> lineChart3 =
                                new ScatterChart<>(xAxis, yAxis);

                        lineChart3.setTitle("Изменение ускорения по оси Z");
                        //defining a series
                        XYChart.Series series3 = new XYChart.Series();
                        series3.setName("график зависимости ускорения от времени");
                        //populating the series with data
                        for (int i = 0; i < empList.size(); i++) {
                            series3.getData().add(new XYChart.Data(time.get(i), ugEz.get(i)));
                        }
                        Scene scene3 = new Scene(lineChart3, 2200, 900);
                        lineChart3.getData().add(series3);

                        stage.setScene(scene3);
                        stage.show();

                        break;
                    default:
                        System.out.println("Incorrect input!");
                }


        }
        else {
        System.out.println("Incorrect input!");
        }

    }

//        System.out.println("График изменения перемещения какой оси вы хотите увидеть?");
//        String eiler = scanner1.next();
//            switch (eiler) {
//                case "x":
//
//                    break;
//                case "y":
//
//                    yAxis.setLabel("угловая скорость по оси Y, град/с");
//
//                    final ScatterChart<Number, Number> lineChart5 =
//                            new ScatterChart<>(xAxis, yAxis);
//
//                    lineChart5.setTitle("Изменение ускорения по оси");
//                    //defining a series
//                    XYChart.Series series5 = new XYChart.Series();
//                    series5.setName("график зависимости ускорения от времени");
//                    //populating the series with data
//                    for (int i = 0; i < empList.size(); i++) {
//                        series5.getData().add(new XYChart.Data(time.get(i), ang_y.get(i)));
//                    }
//                    Scene scene5 = new Scene(lineChart5, 2200, 900);
//                    lineChart5.getData().add(series5);
//
//                    stage.setScene(scene5);
//                    stage.show();
//
//                    break;
//                case "z":
//                    break;
//                default:
//                    System.out.println("Incorrect input!");
//
//        }
//    }






        //creating the chart

//        series.getData().add(new XYChart.Data(1, 23));
//        series.getData().add(new XYChart.Data(2, 14));
//        series.getData().add(new XYChart.Data(3, 15));
//        series.getData().add(new XYChart.Data(4, 24));
//        series.getData().add(new XYChart.Data(5, 34));
//        series.getData().add(new XYChart.Data(6, 36));
//        series.getData().add(new XYChart.Data(7, 22));
//        series.getData().add(new XYChart.Data(8, 45));
//        series.getData().add(new XYChart.Data(9, 43));
//        series.getData().add(new XYChart.Data(10, 17));
//        series.getData().add(new XYChart.Data(11, 29));
//        series.getData().add(new XYChart.Data(12, 25));
//
//
//    }



    public static void main(String[] args) {
        launch(args);
    }
}