package com.vytrack.tests;

import com.vytrack.pages.VyTrack;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class VyTrackWIthPom_userStory10 extends TestBase {

    @Test
    public void test123(){
        VyTrack vyTrack=new VyTrack();
        vyTrack.goTo();
        vyTrack.login("user4","UserUser123");
        vyTrack.getHelp();
    }
}
