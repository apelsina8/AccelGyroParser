//package ru.lab.lab2;
//
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.List;
//
//public class Task2 extends Application {
//
//    private static List<Double> ang_x;
//    private static List<Double> ang_y;
//    private static List<Double> ang_z;
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        launch(args);
//        LineChartSample lineChartSample = new LineChartSample();
//        lineChartSample.start(new Stage());
//        ang_x = lineChartSample.getAngX();
//        ang_y = lineChartSample.getAngY();
//        ang_z = lineChartSample.getAngZ();
//        System.out.println(ang_x);
//    }
//
//    @Override
//    public void start(Stage stage) {
//
//        stage.setTitle("Hello JavaFX"); // установка заголовка
//        Scene scene = new Scene();          // установка длины
//        stage.show();                   // отображение окна на экране
//    }
//}
