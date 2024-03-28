package main.java;

import Model.Model;
import View.View;
import Controller.Controller;

public class CaptureTheQuadrants
{
    public static void main(String[] args)
    {
        View view = new View();
        Model model = new Model();
        new Controller(view, model);
    }
}