package com.vytrack.tests;

import com.vytrack.pages.VyTrack;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class VytrackWithPom_userStory1 extends TestBase {

@Test
public void AC1(){
    VyTrack vyTrack=new VyTrack();
    vyTrack.goTo();
    vyTrack.login("salesmanager105","UserUser123");
    vyTrack.verifyDriverModels();
}



    @Test
    public void AC2(){
        VyTrack vyTrack=new VyTrack();
        vyTrack.goTo();
        vyTrack.login("user4","UserUser123");

        vyTrack.verifyDriverModels();
    }
}
