package pl.edu.pb.wi.controller;

import pl.edu.pb.wi.view.BoardFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new BoardFrame(2));
    }
}