package com.vinstorm.javafx_experiments.dev.vinayak.aaaam;

import java.io.IOException;

public class LayoutStage {

	static FxmlTest ft = new FxmlTest();
	
	static void openSpecificStage(int i) throws IOException {
		switch (i) {
			case 1: HBoxTest.hboxShow();
			break;
			case 2: VBoxTest._VBoxTest_Setup();
			break;
			case 3: BorderPaneTest._BorderPaneTest_Setup();
			break;
			case 4: StackPaneTest._StackPaneTest_Setup();
			break;
			case 5: TextFlowTest._TextFlowTest_Setup();
			break;
			case 6: AnchorPaneTest._AnchorPaneTest_Setup();
			break;
			case 7: TitlePaneTest._TitlePaneTest_Setup();
			break;
			case 8: GridPaneTest._GridPaneTest_Setup();
			break;
			case 9: FlowPanelTest._FlowPanelTest_Setup();
			break;
			case 10: PaneTest._PaneTest_Setup();
			break;
			case 11: {
				ft.loadFxml();
				FxmlTest.openFxmlWindow();
			}
			break;
		}
	}
}