package org.example.Controller;

import org.example.Entities.Point;

public interface LightingController {
    
        void performTurnOn(Point startPoint, Point endPoint);
    
        void performTurnOff(Point startPoint, Point endPoint);

        void performToggle(Point startPoint, Point endPoint);
   
}
