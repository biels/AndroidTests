package com.biel.samplexre.reportmodel1;

import com.biel.xre.generation.ReportFragment;
import com.biel.xre.generation.xhtml.*;

public class DealDetailsFragment extends ReportFragment {

	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		Literal header = new Literal("Details header");
		
		return new LinearLayout(new Tag("h2", header), new Literal("Table here")).getXHTML();
	}

}
