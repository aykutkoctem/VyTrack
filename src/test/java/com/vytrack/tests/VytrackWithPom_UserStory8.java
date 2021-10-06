package com.vytrack.tests;

import com.vytrack.pages.VyTrack;
import org.junit.jupiter.api.Test;

public class VytrackWithPom_UserStory8 {
    @Test
    public void vehicleOto(){
        VyTrack vyTrack=new VyTrack();

        vyTrack.VehicleOdometer();
    }
}
